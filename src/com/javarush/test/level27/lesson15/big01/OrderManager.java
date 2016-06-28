package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.LinkedBlockingQueue;


public class OrderManager implements Observer{

    private LinkedBlockingQueue<Order> queue = new LinkedBlockingQueue<>();

    public OrderManager() {
        Thread daemon =new Thread(){
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        for (Cook cook : StatisticEventManager.getInstance().getCooks()){
                            while (queue.peek() == null) Thread.sleep(10);
                            if (!cook.isBusy()) cook.startCookingOrder(queue.poll());
                        }
                    }catch (InterruptedException ex) {}
                }
            }
        };
        daemon.setDaemon(true);
        daemon.start();
    }

    @Override
    public void update(Observable o, Object order) {

        try {

            if (order != null ) {

                queue.put((Order) order);
            }

        }catch (InterruptedException ex) {}

    }
}
