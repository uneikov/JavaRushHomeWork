package com.javarush.test.level09.lesson11.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Гласные и согласные буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа должна вывести на экран две строки:
1. первая строка содержит только гласные буквы
2. вторая - только согласные буквы и знаки препинания из введённой строки.
Буквы соединять пробелом, каждая строка должна заканчиваться пробелом.

Пример ввода:
Мама мыла раму.
Пример вывода:
а а ы а а у
М м м л р м .
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<Character> vowels = new ArrayList<>();
        ArrayList<Character> nonvowels = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String myString = reader.readLine();
        char[] myCharString = myString.toCharArray();
        for (int i = 0; i < myString.length(); i++)
        {
            if (myCharString[i] != ' ')
            {
                if (isVowel(myCharString[i]))
                    vowels.add(myCharString[i]);
                else
                    nonvowels.add(myCharString[i]);
            }
        }
        for (Character o : vowels) System.out.print(o + " "); System.out.println();
        for (Character o : nonvowels) System.out.print(o + " "); System.out.println();
    }


    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    //метод проверяет, гласная ли буква
    public static boolean isVowel(char c)
    {
        c = Character.toLowerCase(c);  //приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   //ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}
