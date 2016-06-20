package com.javarush.test.level26.lesson15.big01.command;


import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

import java.util.Collection;
import java.util.ResourceBundle;

class InfoCommand implements Command {

    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "info_en");

    @Override
    public void execute()
    {
        boolean empty = true;
        ConsoleHelper.writeMessage(res.getString("before"));
        Collection<CurrencyManipulator> collection = CurrencyManipulatorFactory.getAllCurrencyManipulators();
        for (CurrencyManipulator moneyHolder : collection){
            if (moneyHolder.hasMoney()) {
                empty = false;
                System.out.println(moneyHolder.getCurrencyCode() + " - " + moneyHolder.getTotalAmount());
            }
        }
        if (empty) System.out.println(res.getString("no.money"));
    }
}
