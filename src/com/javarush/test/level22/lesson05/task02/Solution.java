package com.javarush.test.level22.lesson05.task02;

import java.util.LinkedList;
import java.util.Stack;

/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException{
        if (string == null) throw new TooShortStringException();
        LinkedList<Character> chars = new LinkedList<>();
        String result = "";
        int tabs = 0;
        for (int i = 0; i < string.length(); i++){
            if(string.charAt(i) == '\t')tabs++;
            else if(tabs == 1) chars.add(string.charAt(i));
            if (tabs == 2) break;
        }
        if (tabs < 2) throw new TooShortStringException();
        else while (chars.size() != 0) result += chars.pollFirst();

        return result;
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("tab0\ttab\ttab1\t"));       //tab
        System.out.println(getPartOfString("\t\t"));                    //
        System.out.println(getPartOfString("123\t123"));                //Exception
        System.out.println(getPartOfString(null));                      //Exception
    }
}
