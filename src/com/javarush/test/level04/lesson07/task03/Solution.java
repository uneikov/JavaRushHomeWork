package com.javarush.test.level04.lesson07.task03;

/* Положительные числа
Ввести с клавиатуры три целых числа. Вывести на экран количество положительных чисел в исходном наборе.
Пример для чисел -4 6 6:
2
Пример для чисел -6 -6 -3:
0
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        String s2 = reader.readLine();
        String s3 = reader.readLine();
        int a1 = Integer.parseInt(s1);
        int a2 = Integer.parseInt(s2);
        int a3 = Integer.parseInt(s3);
        int count = 0;
        if (a1 > 0) count++;
        if (a2 > 0) count++;
        if (a3 > 0) count++;
        System.out.println(count);
    }
}
