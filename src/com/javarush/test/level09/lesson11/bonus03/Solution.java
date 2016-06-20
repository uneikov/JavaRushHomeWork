package com.javarush.test.level09.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел). Слова вывести в возрастающем порядке, числа - в убывающем.
Пример ввода:
Вишня
1
Боб
3
Яблоко
2
0
Арбуз
Пример вывода:
Арбуз
3
Боб
2
Вишня
1
0
Яблоко
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true)
        {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array)
        {
            System.out.println(x);
        }

    }

    public static void sort(String[] array)
    {
        // Создаем массивы для чисел и строк
        ArrayList<String> intList = new ArrayList<>();
        ArrayList<String> strList = new ArrayList<>();
        ArrayList<Integer> iList = new ArrayList<>();

        // Разбиваем исходный массив на 2 - для чисел и строк
        // Если элемент - число, то isDigit = true
        boolean[] isDigit = new boolean[array.length];
        for ( int i = 0; i < array.length; i++)
        {
            if (isNumber(array[i])){
                intList.add(array[i]);
                isDigit[i] = true;
            }
            else {
                    strList.add(array[i]);
                    isDigit[i] = false;
            }
        }

        for (String s: intList) iList.add(Integer.parseInt(s));

        Integer[] i_array = iList.toArray(new Integer[iList.size()]);
        String[] s_array = strList.toArray(new String[strList.size()]);

        bubbleSortForInteger(i_array, true);
        bubbleSortForString(s_array, false);

        int di = 0;
        int si = 0;
        for ( int i = 0; i < array.length; i++)
        {
            if (isDigit[i])
            {
                array[i] = String.valueOf(i_array[di++]);
            } else
            {
                array[i] = s_array[si++];
            }
        }

    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b)
    {
        return a.compareTo(b) > 0;
    }

    //  Пузырьковая сортировка для чисел
    public static void bubbleSortForInteger(Integer[] array, boolean fromBigToSmall)
    {
        for (; ; )
        {  // Сортировка массива чисел
            boolean s = false;
            for (int i = 1; i < array.length; i++)
            {
                int temp = 0;
                if (array[i - 1] < array[i])
                {
                    temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;
                    s = true;
                }
            }
            if (!s)
            {
                if (fromBigToSmall) return;
                else {Collections.reverse(Arrays.asList(array)); return;}
            }
        }
    }

    //  Пузырьковая сортировка для строк
    public static void bubbleSortForString(String[] array, boolean fromBigToSmall)
    {
        for (; ; )
        {  // Сортировка массива строк
            boolean s = false;
            for (int i = 1; i < array.length; i++)
            {
                String temp = "";
                if (!isGreaterThan(array[i - 1], array[i]))
                {
                    temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;
                    s = true;
                }
            }
            if (!s)
            {
                if (fromBigToSmall) return;
                else {Collections.reverse(Arrays.asList(array)); return;}
            }
        }
    }

    //строка - это на самом деле число?
    public static boolean isNumber(String s)
    {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            char c = chars[i];
            if ((i != 0 && c == '-') //есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-') ) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
