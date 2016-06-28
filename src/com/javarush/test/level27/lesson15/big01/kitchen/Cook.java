package com.javarush.test.level27.lesson15.big01.kitchen;


import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;
import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;

public class Cook extends Observable {

    private String name;
    private boolean busy;

    public Cook(String name) {
        this.name = name;
    }

    public void startCookingOrder(Order order) {

        busy = true;
        ConsoleHelper.writeMessage("Start cooking - " + order.toString()
                + ", cooking time " + order.getTotalCookingTime() + "min");
        try {
            Thread.sleep(10 * order.getTotalCookingTime());
        }catch (InterruptedException ex) {}

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
