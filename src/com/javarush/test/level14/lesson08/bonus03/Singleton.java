package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by URAN on 25.03.2016.
 */
public class Singleton
{
    static Singleton s = new Singleton();

    private Singleton() {}

    static Singleton getInstance(){return s;}
}
