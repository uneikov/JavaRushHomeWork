package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution {

    public static String getPartOfString(String string) throws TooShortStringException{
        int spaces = 1;
        StringBuilder sb = new StringBuilder();
        if (string == null) throw new TooShortStringException();
        int begin = string.indexOf(" ") + 1;
        for (int i = begin; i < string.length(); i++){
            if (string.charAt(i) == ' ') spaces++;
            sb.append(string.charAt(i));
            if (spaces == 4) { begin = i + 1; break; }
        }
        if (spaces < 4) throw new TooShortStringException();
        for (int i = begin; i < string.length(); i++){
            if (string.charAt(i) == ' ') sb.append(string.charAt(i));
            else { begin = i; break; }
        }
        for (int i = begin; i < string.length(); i++) {
            if (string.charAt(i) != ' ') sb.append(string.charAt(i));
            else break;
        }
        return sb.toString();
    }

    public static class TooShortStringException extends Exception{
        TooShortStringException(){}
    }

    public static void main(String[] args)throws TooShortStringException{
        String toCut = "JavaRush - лучший сервис обучения Java.";
        String cutted = getPartOfString(toCut);
        System.out.println(cutted);
    }
}
