package com.javarush.test.level26.lesson15.big01.command;


import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

class DepositCommand implements Command {

    private ResourceBundle res =
            ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "deposit_en");

    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));
        String code = ConsoleHelper.askCurrencyCode();
        String[] depo = ConsoleHelper.getValidTwoDigits(code);
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);
        try{
            int banknoteNominal = Integer.parseInt(depo[0]);
            int numberOfBanknotes = Integer.parseInt(depo[1]);
            manipulator.addAmount(banknoteNominal, numberOfBanknotes);
            ConsoleHelper.writeMessage(String.format(res.getString("success.format"),banknoteNominal*numberOfBanknotes, code));
        }catch (NumberFormatException badNumber){
            ConsoleHelper.writeMessage(res.getString("invalid.data"));
        }
    }
}
