package com.javarush.test.level10.lesson11.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Количество букв
Ввести с клавиатуры 10 строчек и подсчитать в них количество различных букв (для 33 букв алфавита).  Вывести результат на экран.
Пример вывода:
а 5
б 8
в 3
г 7
д 0
…
я 9
*/

public class Solution
{
    public static void main(String[] args)  throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++)
        {
            alphabet.add(abcArray[i]);
        }

        //ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++)
        {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }

        // Счетчик букв алфавита
        ArrayList<Integer> countChar = new ArrayList<>(alphabet.size());
        for (int t =0; t < abcArray.length; t++) countChar.add(0);

        // Основная часть
        for (String s : list) // Цикл по строкам
        {
            char[] sArray = s.toCharArray();
            for (int k = 0; k < sArray.length; k++) // Цикл по буквам слова
            {
               for (int charCount = 0; charCount < abcArray.length; charCount++) // Цикл по алфавиту
               {
                if (alphabet.get(charCount).equals(sArray[k]))
                    countChar.set(charCount, countChar.get(charCount)+1);
               }
            }
        }

        // Выдача результата
        for ( int j = 0; j < abcArray.length; j++)
        {
            System.out.println(alphabet.get(j) + " " + countChar.get(j));
        }
    }
}
