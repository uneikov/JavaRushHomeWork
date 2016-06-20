package com.javarush.test.level07.lesson06.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Удали последнюю строку и вставь её в начало
1. Создай список строк.
2. Добавь в него 5 строчек с клавиатуры.
3. Удали последнюю строку и вставь её в начало. Повторить 13 раз.
4. Используя цикл выведи содержимое на экран, каждое значение с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        String s;
        ArrayList<String> stringArray = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // ввести элементы строкового массива
        for(int i = 0; i < 5; i++)
        {
            stringArray.add(br.readLine());
        }
        //удали последнюю строку и вставь её в начало, повторить 13 раз.
        for(int i = 0; i < 13; i++)
        {
            s = stringArray.get(4);
            stringArray.remove(4);
            stringArray.add(0, s);
        }
        // распечатать массив
        for(int i = 0; i < stringArray.size(); i++) System.out.println(stringArray.get(i));
    }
}
