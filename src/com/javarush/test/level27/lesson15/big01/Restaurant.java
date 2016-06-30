package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {

    private static final int ORDER_CREATING_INTERVAL = 100;
    private static final LinkedBlockingQueue<Order> QUEUE = new LinkedBlockingQueue<>();

    public static void main(String[] args)
    {

        Waitor waitor = new Waitor();

        Cook cook1 = new Cook("James Cook");
        cook1.setQueue(QUEUE);
        cook1.addObserver(waitor);
        Cook cook2 = new Cook("Joe Cooker");
        cook2.setQueue(QUEUE);
        cook2.addObserver(waitor);

        List<Tablet> tablets = new ArrayList<>();
        for (int i = 0; i < 5 ; i++) {
            tablets.add(new Tablet(i));
            tablets.get(i).setQueue(QUEUE);
        }

        Thread cook1Thread = new Thread(cook1);
        Thread cook2Thread = new Thread(cook2);
        cook1Thread.start();
        cook2Thread.start();

        Thread task = new Thread(new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL));
        task.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignore) {}

        task.interrupt();

        while (!QUEUE.isEmpty()){
            try {
                Thread.sleep(1);
            }catch (InterruptedException ex) {}
        }

        while ((cook1.isBusy())||(cook2.isBusy())) {
            try {
                Thread.sleep(1);
            }catch (InterruptedException ex) {}
        }

        cook1Thread.interrupt();
        cook2Thread.interrupt();

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();

    }

}
