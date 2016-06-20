package com.javarush.test.level05.lesson12.home05;

/* Вводить с клавиатуры числа и считать их сумму
Вводить с клавиатуры числа и считать их сумму, пока пользователь не введёт слово «сумма». Вывести на экран полученную сумму.
*/


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int sum = 0;
        int d =0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        if (!s.equals("сумма"))
        {
            for (; !s.equals("сумма"); )
            {
                d = Integer.parseInt(s);
                sum += d;
                s = reader.readLine();
                if (s.equals("сумма")) break;
            }
            System.out.println(sum);
        }
        else System.out.println(sum);
    }
}
