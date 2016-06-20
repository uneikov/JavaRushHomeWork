package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        List<String> parmFirstList = new LinkedList<>();
        List<String> parmSecondList = new LinkedList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Pattern word = Pattern.compile("\\w+");
        Pattern plusword = Pattern.compile("=[^=]+");

        String url = reader.readLine();

        String[] urlPart = url.split("\\?"); // отделяем параметры от адреса
        String[] parmPart = urlPart[1].split("\\&"); // разделяем параметры по строковым переменным
        for (int i =0; i < parmPart.length; i++) {
            String s = parmPart[i];
            Matcher words = word.matcher(s);
            if(words.find()) {// ищем имена параметров
                parmFirstList.add(s.substring(words.start(), words.end()));
            }
            Matcher pluswords = plusword.matcher(s);
            if(pluswords.find()) {// ищем сами параметры
                parmSecondList.add(s.substring(pluswords.start()+1, pluswords.end()));
            }
            else parmSecondList.add(""); // усли параметра нет, добавляем пустую строку
        }
        // печать параметров
        for (int i = 0; i < parmFirstList.size(); i++) System.out.print(parmFirstList.get(i) + " ");
        System.out.println();
        for (int i =0; i <parmFirstList.size(); i++) {
            if ("obj".equals(parmFirstList.get(i))) {
                String objParm = parmSecondList.get(i);
                if (isDigit(objParm)) alert(Double.parseDouble(objParm));// выводим численные значения параметров
                else alert(objParm); // выводим строковые значения параметров
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
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
}
