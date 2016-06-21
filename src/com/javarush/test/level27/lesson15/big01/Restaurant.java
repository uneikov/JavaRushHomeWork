package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;

public class Restaurant {

    public static void main(String[] args)
    {
        Cook cook = new Cook("James Cook");
        Waitor waitor1 = new Waitor();
        Tablet tablet5 = new Tablet(5);

        cook.addObserver(waitor1);
        tablet5.addObserver(cook);

        tablet5.createOrder();

    }
}

