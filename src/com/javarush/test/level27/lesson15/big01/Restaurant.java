package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticManager;

public class Restaurant {

    public static void main(String[] args)
    {
        Cook cook1 = new Cook("James Cook");
        StatisticManager.getInstance().register(cook1);

        Waitor waitor1 = new Waitor();

        Tablet tablet5 = new Tablet(5);

        cook1.addObserver(waitor1);
        tablet5.addObserver(cook1);

        tablet5.createOrder();


        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();

    }
}
