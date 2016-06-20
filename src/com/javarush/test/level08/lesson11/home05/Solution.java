package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String[] sIn = s.trim().split(" ");
        // разбить строку на слова, один пробел между словами удаляется, остальнве если есть
        // заменяются пустыми строками!!! так работает split()
        String sOut = "";
        for (int i = 0; i < sIn.length; i++)
        {
            sOut = !sIn[i].equals("")
                    ? sOut.concat(sIn[i].substring(0, 1).toUpperCase() + sIn[i].substring(1) + " ")
                    : sOut.concat(" ");
            /*
            if (!sIn[i].equals(""))
                sOut = sOut.concat(sIn[i].substring(0, 1).toUpperCase() + sIn[i].substring(1) + " ");
            else sOut = sOut.concat(" ");
            */
        }
        System.out.println(sOut);
    }
}