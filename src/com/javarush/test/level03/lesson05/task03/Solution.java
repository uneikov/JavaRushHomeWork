package com.javarush.test.level03.lesson05.task03;

/* Конвертер времени
Добавьте метод public static int convertToSeconds(int hour) который будет конвертировать часы в секунды.
Вызовите его дважды в методе main с любыми параметрами. Результаты выведите на экран, каждый раз с новой строки.
*/

public class Solution
{

    public static int convertToSeconds(int hour){
        int seconds;
        seconds = hour*3600;
        return seconds;
    };

    public static void main(String[] args) {
        System.out.println(convertToSeconds(3));
        System.out.println(convertToSeconds(5));
    }
}