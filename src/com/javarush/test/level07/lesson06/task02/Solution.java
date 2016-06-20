package com.javarush.test.level07.lesson06.task02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Самая длинная строка
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую длинную строку в списке.
4. Выведи найденную строку на экран.
5. Если таких строк несколько, выведи каждую с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<String> stringArray = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // ввести элементы строкового массива
        for(int i = 0; i < 5; i++)
        {
            stringArray.add(br.readLine());
        }
        // найти самую длинную строку в массиве
        int maxLengthString = stringArray.get(0).length();
        for(int i = 1; i < 5; i++)
        {
            if (maxLengthString < stringArray.get(i).length())
                maxLengthString = stringArray.get(i).length();
        }
        // распечатать самую длинную строку или строки, если одинаковой длины
        for(int i = 0; i < 5; i++)
        {
            if (maxLengthString == stringArray.get(i).length())
                System.out.println(stringArray.get(i));
        }
    }
}
