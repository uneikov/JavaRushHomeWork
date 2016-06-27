package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private static final int ORDER_CREATING_INTERVAL = 100;

    public static void main(String[] args)
    {

        List<Tablet> tablets = new ArrayList<>();
        tablets.add(new Tablet(1));
        tablets.add(new Tablet(2));
        tablets.add(new Tablet(3));
        tablets.add(new Tablet(4));

        Cook cook1 = new Cook("James Cook");
        Cook cook2 = new Cook("Joe Cooker");

        StatisticEventManager.getInstance().register(cook1);
        StatisticEventManager.getInstance().register(cook2);

        Waitor waitor1 = new Waitor();

        cook1.addObserver(waitor1);
        cook2.addObserver(waitor1);

        tablets.get(0).addObserver(cook1);
        tablets.get(1).addObserver(cook1);
        tablets.get(2).addObserver(cook2);
        tablets.get(3).addObserver(cook2);


        Thread task = new Thread(new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL));
        task.start();
        try {
            Thread.sleep(1000);
            task.interrupt();
        } catch (InterruptedException ignore) {}
        task.interrupt();

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();

    }

}
