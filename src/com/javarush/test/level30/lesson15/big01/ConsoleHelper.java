package com.javarush.test.level30.lesson15.big01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by URAN on 11.07.2016.
 */
public class ConsoleHelper {
    public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString(){
        String line = "";
        while (true) {
            try {
                line = reader.readLine();
                break;
            } catch (IOException ex) {
                writeMessage("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            }
        }
        return line;
    }

    public static int readInt(){
        int result = 0;
        while (true) {
            try {
                result = Integer.parseInt(readString());
                break;
            } catch (NumberFormatException badnum) {
                writeMessage("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
            }
        }
         return result;
    }
}
