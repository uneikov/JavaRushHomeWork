package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;


public class ConsoleHelper {

    private static BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in));
    private static ResourceBundle res =
            ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "common_en");

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException{
        String inputString = "";
        while (true) {
            try {
                inputString = reader.readLine();
            } catch (IOException io) {
                continue;
            }
            if (inputString.equalsIgnoreCase("exit")) throw new InterruptOperationException();
            else return inputString;
        }
    }

    public static String askCurrencyCode() throws InterruptOperationException{

        boolean valid = false;
        String input = null;
        writeMessage(res.getString("choose.currency.code"));
        while (!valid)
        {
            input = readString();
            valid = input.matches("[a-zA-Z]+") && input.length() == 3;
            if (!valid) writeMessage(res.getString("invalid.data"));
        }
        return input.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException{
        boolean valid = false;
        String[] input = null;
        writeMessage(String.format(res.getString("choose.denomination.and.count.format"), currencyCode));
        while (!valid)
        {
            input = readString().split(" ");
            int k; int v;
            try{
                k = Integer.parseInt(input[0]);
                v = Integer.parseInt(input[1]);
            }catch (Exception e){
                writeMessage(res.getString("invalid.data"));
                continue;
            }
            if (k <= 0 || v <= 0 || input.length > 2) {
                writeMessage(res.getString("invalid.data"));
                continue;
            }
            else valid = true;
        }
        return input;
    }

    public static Operation askOperation()throws InterruptOperationException{
        int operationNumber = 1;
        boolean valid = false;
        writeMessage(res.getString("choose.operation")+ "\n" +
        res.getString("operation.INFO")+ ": 1;\n" +
        res.getString("operation.DEPOSIT") + ": 2;\n" +
        res.getString("operation.WITHDRAW") + ": 3;\n" +
        res.getString("operation.EXIT") + ": 4;\n");
        while (!valid) {

            String choice = readString();
            if (choice.matches("\\d{1}")) operationNumber = Integer.parseInt(choice);
            else {
                writeMessage(res.getString("invalid.data"));
                continue;
            }
            if( operationNumber >=1 && operationNumber <= 4 ) valid = true;
            else writeMessage(res.getString("invalid.data"));
        }
        return Operation.getAllowableOperationByOrdinal(operationNumber);
    }

    public static void printExitMessage(){
        ConsoleHelper.writeMessage(res.getString("the.end"));
    }
    public static void close(){
        try {
            reader.close();
        }catch (IOException ex){}
    }
}
