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
        OrderManager orderManager = new OrderManager();

        List<Tablet> tablets = new ArrayList<>();

        Cook cook1 = new Cook("James Cook");
        Cook cook2 = new Cook("Joe Cooker");

        StatisticEventManager.getInstance().register(cook1);
        StatisticEventManager.getInstance().register(cook2);

        Waitor waitor1 = new Waitor();

        cook1.addObserver(waitor1);
        cook2.addObserver(waitor1);

        cook1.addObserver(orderManager);
        cook2.addObserver(orderManager);



        for (int i = 0; i < 5 ; i++) {
            tablets.add(new Tablet(i));
            tablets.get(i).addObserver(orderManager);
            tablets.get(i).addObserver(orderManager);
        }


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
