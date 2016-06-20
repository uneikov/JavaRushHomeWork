package com.javarush.test.level15.lesson04.task01;

/* Что-то лишнее
1. Программа должна выводить следующее:
Это double
Это Object
Это double
Это Integer
Это double

2 Удалите реализации всех лишних методов
*/

public class Solution {

    public static void main(String[] args) {
        print((short) 1); // примитивный тип - №1
        print((Number) 1); // типObject -№2
        print(1); // примитивный тип - №1
        print((Integer) 1); // тип Integer - №3
        print((int) 1); // примитивный тип - №1
    }

    public static void print(Integer i) { // №3
        System.out.println("Это Integer");
    }
    public static void print(Object i) { // №2
        System.out.println("Это Object");
    }
    public static void print(double i) { // №1
        System.out.println("Это double");
    }

}
