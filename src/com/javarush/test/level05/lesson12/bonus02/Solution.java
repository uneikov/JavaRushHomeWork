package com.javarush.test.level05.lesson12.bonus02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Нужно добавить в программу новую функциональность
Задача: Программа вводит два числа с клавиатуры и выводит минимальное из них на экран.
Новая задача: Программа вводит пять чисел с клавиатуры и выводит минимальное из них на экран.
*/

public class Solution
{

    public static void main(String[] args) throws Exception
    {
        int[]  myDigits = {0, 0, 0, 0, 0};
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i =0; i < myDigits.length; i++)
        {

            myDigits[i] = Integer.parseInt(reader.readLine());
        }
        int minimum = min(myDigits);
        System.out.println("Minimum = " + minimum);
    }


    public static int min(int myDigits[])
    {
        int min = myDigits[0];
        for (int i = 1; i < myDigits.length; i++)
        {
            if (myDigits[i] < min) min = myDigits[i];
        }
        return min;
    }
}
