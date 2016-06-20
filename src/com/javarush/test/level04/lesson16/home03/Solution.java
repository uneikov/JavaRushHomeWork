package com.javarush.test.level04.lesson16.home03;

import java.io.*;

/* Посчитать сумму чисел
Вводить с клавиатуры числа и считать их сумму. Если пользователь ввел -1, вывести на экран сумму и завершить программу.  -1 должно учитываться в сумме.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        int sum = 0;
        int a = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        do
        {
            String s = reader.readLine();
            a = Integer.parseInt(s);
            sum += a;
        }
        while (a != -1);
        System.out.println(sum);
    }
}
