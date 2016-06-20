package com.javarush.test.level06.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
Пример ввода:
3
2
15
6
17
Пример вывода:
2
3
6
15
17
*/
import java.util.Arrays;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        Integer[] d = new Integer[5]; // Создание и инициализация целочисленного массива
        String s;

        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
        for( int i = 0; i < 5; i++)
        {
            s = reader.readLine();
            d[i] = Integer.parseInt(s);
        }
        Arrays.sort(d); // Сортировка массива
        for( int i = 0; i <5; i++)
        {
            System.out.println(d[i]);
        }
    }
}
