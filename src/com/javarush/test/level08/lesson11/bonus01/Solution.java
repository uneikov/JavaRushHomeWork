package com.javarush.test.level08.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
Используйте коллекции.
*/

public class Solution
{

    public static void main(String[] args) throws IOException
    {
        HashMap<Integer, String > monthOfTheYear = new HashMap<>();
        monthOfTheYear.put(1, "January");
        monthOfTheYear.put(2, "February");
        monthOfTheYear.put(3, "March");
        monthOfTheYear.put(4, "April");
        monthOfTheYear.put(5, "May");
        monthOfTheYear.put(6, "June");
        monthOfTheYear.put(7, "July");
        monthOfTheYear.put(8, "August");
        monthOfTheYear.put(9, "September");
        monthOfTheYear.put(10, "November");
        monthOfTheYear.put(11, "October");
        monthOfTheYear.put(12, "December");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String m = reader.readLine();
        for (Map.Entry entry : monthOfTheYear.entrySet())
        {
            if (entry.getValue().equals(m))
            System.out.println(entry.getValue() + " is " + entry.getKey() + " month");
        }
    }

}
