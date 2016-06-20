package com.javarush.test.level05.lesson12.bonus03;

import java.io.*;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/
import java.util.Arrays;
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maximum = Integer.parseInt(reader.readLine());
        Integer myDigits[] = new Integer[maximum];
        //java.util.Arrays.fill(myDigits, 0);
        for (int i = 0; i < maximum; i++ )
        {
            myDigits[i] = Integer.parseInt(reader.readLine());
        }
        System.out.println(max(myDigits));
    }

    public static int max(Integer myDigits[])
    {
        int max = myDigits[0];
        for (int i = 1; i < myDigits.length; i++)
        {
            if (myDigits[i] > max) max = myDigits[i];
        }
        return max;
    }
}
