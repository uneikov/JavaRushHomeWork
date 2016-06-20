package com.javarush.test.level15.lesson12.home01;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/* Разные методы для разных типов
1. Считать с консоли данные, пока не введено слово "exit".
2. Для каждого значения, кроме "exit", вызвать метод print. Если значение:
2.1. содержит точку '.', то вызвать метод print для Double;
2.2. больше нуля, но меньше 128, то вызвать метод print для short;
2.3. больше либо равно 128, то вызвать метод print для Integer;
2.4. иначе, вызвать метод print для String.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        List<String > list = new LinkedList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // читаем строки до "exit" вместе с "exit"
        for (;;)
        {
            String in = reader.readLine();
            list.add(in);
            if ("exit".equals(in)) break;
        }

        // вывод строк кроме "exit"
        for (String  s : list) {
            if (!"exit".equals(s)) {
                if (isDigit(s)) { // если число
                    if (s.contains(".")) print(Double.parseDouble(s));
                    else {
                        int in = Integer.parseInt(s);
                        if (in > 0 && in < 128 ) print((short) in);
                        if (in >= 128) print((Integer) in);
                        if (in < 0) print(s);
                    }
                }
                else { // если строка
                    print(s);
                }
            }
        }
    }

    public static  boolean isDigit(String s) // является ли строка числом?
    {
        boolean mark = false;
        int idx = 0;
        int onlyOne = 0;
        if ('-' == s.charAt(0)) idx = 1; // учет знака
        for (int i = idx; i < s.length(); i++)
        {
            char currentChar = s.charAt(i);
            if (currentChar == '.') onlyOne++;// считаем точки
            else
            {
                if (!isDigit(currentChar)) {mark = false; break;}
                else mark = true;
            }
        }
        return (mark && (onlyOne < 2));
    }

    public static boolean isDigit(char c){ // является ли символ цифрой?
        boolean mark = false;
        char[] digits = {'0','1','2','3','4','5','6','7','8','9'};
        for (int i = 0; i < digits.length; i ++)
        {
            if (c == digits[i]) {mark = true; break;}
        }
        return mark;
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
