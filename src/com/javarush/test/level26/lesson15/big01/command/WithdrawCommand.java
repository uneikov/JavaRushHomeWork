package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.*;

class WithdrawCommand implements Command{

    private ResourceBundle res =
            ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "withdraw_en");

    @Override
    public void execute() throws InterruptOperationException {
        boolean valid = false;
        int amountToWithdraw;
        String code;
        CurrencyManipulator manipulator;
        List<Integer> keys;
        Map<Integer, Integer> withdrawMap;
        code = ConsoleHelper.askCurrencyCode();
        manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);
        ConsoleHelper.writeMessage(res.getString("before"));
        while (!valid) {

            ConsoleHelper.writeMessage(res.getString("specify.amount"));
            String amount = ConsoleHelper.readString();

            if (isValidDidit(amount)) amountToWithdraw = Integer.parseInt(amount);
            else {
                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
                continue;
            }

            if (manipulator.isAmountAvailable(amountToWithdraw))
            {
                valid = true;
                try {
                    withdrawMap = manipulator.withdrawAmount(amountToWithdraw);
                    keys = new ArrayList<>(withdrawMap.keySet());
                    Collections.sort(keys, Collections.<Integer>reverseOrder());
                    for (Integer key : keys){
                        System.out.println("\t" + key + " - " + withdrawMap.get(key));
                    }
                }catch (NotEnoughMoneyException ex){
                    ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
                    continue;
                }

                ConsoleHelper.writeMessage(String.format(res.getString("success.format"), amountToWithdraw, code));
            }
            else {
                ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                continue;
            }
        }
    }

    private boolean isValidDidit(String amount){
        return amount.matches("[0-9]+");
    }
}
