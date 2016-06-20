package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class ConsoleHelper {

    private static final BufferedReader reader =
            new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString() throws IOException{

        return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException{

        List<Dish> result = new ArrayList<>();
        boolean validDish;
        String nextDish;
        Dish[] dishes = Dish.values();
        writeMessage("Choose dish from the menu, please");
        writeMessage(Dish.allDishesToString());

        while (true){
            nextDish = readString();
            if (nextDish.equalsIgnoreCase("exit")) break;
            validDish = false;
            for (int i = 0; i < dishes.length ; i++) {
                if (dishes[i].toString().equals(nextDish)) {
                    result.add(dishes[i]);
                    validDish = true;
                    break;
                }
            }
            if (!validDish) writeMessage(nextDish + " is not detected");
        }

        return result;
    }
}
