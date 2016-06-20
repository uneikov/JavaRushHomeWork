package com.javarush.test.level13.lesson02.task05;

/* 4 ошибки
Исправь 4 ошибки в программе, чтобы она компилировалась.
Объявление интерфейсов не изменять.
*/

public class Solution
{

    public static void main(String[] args) throws Exception
    {
        Hobbie HOBBIE = new Hobbie(); // №3 - убрать static, private
        System.out.println(HOBBIE.toString()); // №4 - убрать Dream()
        System.out.println(new Hobbie().toString());

    }

        interface Desire
        {
        }

        interface Dream
        {

        }

        static class Hobbie implements Desire, Dream // №1 - исправить наследование, №2 - сделать класс static
        {
            static int INDEX = 1;

            @Override
            public String toString()
            {
                INDEX++;
                return "" + INDEX;
            }
        }

}
