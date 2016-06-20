package com.javarush.test.level10.lesson11.home09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Одинаковые слова в списке
Ввести с клавиатуры в список 20 слов. Нужно подсчитать количество одинаковых слов в списке.
        Результат нужно представить в виде словаря Map<String, Integer>, где первый параметр – уникальная строка,
        а второй – число, сколько раз данная строка встречалась в списке.
        Вывести содержимое словаря на экран.
        В тестах регистр (большая/маленькая буква) влияет на результат.
        */

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> words = new ArrayList<String>();
        for (int i = 0; i < 20; i++)
        {
            words.add(reader.readLine());
        }

        Map<String, Integer> map = countWords(words); // Подсчет слов

        for (Map.Entry<String, Integer> pair : map.entrySet())
        {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }

    public static Map<String, Integer> countWords(ArrayList<String> list)
    {
        HashMap<String, Integer> result = new HashMap<String, Integer>();
        int[] count = new int[list.size()];

        for (int index = 0; index < list.size(); index++)
        {
            String word = list.get(index);
            for (int innerIdx = 0; innerIdx < list.size(); innerIdx++)
            {
                if (word.equals(list.get(innerIdx))) count[index]++;
            }
        }

        for (int index = 0; index < list.size(); index++)
        {
            result.put(list.get(index), count[index]);
        }

        return result;
    }

}
