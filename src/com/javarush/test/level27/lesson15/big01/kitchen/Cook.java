package com.javarush.test.level27.lesson15.big01.kitchen;


import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;
import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;

public class Cook extends Observable implements Runnable{

    private String name;
    private boolean busy;
    private LinkedBlockingQueue<Order> queue;

    public Cook(String name) {
        this.name = name;
    }

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                while (queue.peek() == null) Thread.sleep(10); // if new order exist ...
                if (!isBusy()) startCookingOrder(queue.poll()); // take order for cooking
            }catch (InterruptedException ex) {}
        }
    }

    public void startCookingOrder(Order order) {

        busy = true;
        ConsoleHelper.writeMessage("Start cooking - " + order.toString()
                + ", cooking time " + order.getTotalCookingTime() + "min");
        try {
            Thread.sleep(10 * order.getTotalCookingTime());
        }catch (InterruptedException ex) {}
        // cooking finished cook may put order for waitor //
        setChanged();
        notifyObservers(order);

        StatisticEventManager.getInstance().register(
                new CookedOrderEventDataRow(order.getTablet().toString(),
                        this.toString(), order.getTotalCookingTime() * 60, order.getDishes()));

        busy = false;
    }

    public boolean isBusy() {
        return busy;
    }

    @Override
    public String toString() {
        return name;
    }
}
