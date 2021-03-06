package com.javarush.test.level27.lesson15.big01;


import com.javarush.test.level27.lesson15.big01.ad.AdvertisementManager;
import com.javarush.test.level27.lesson15.big01.ad.NoVideoAvailableException;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;
import com.javarush.test.level27.lesson15.big01.kitchen.TestOrder;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;
import com.javarush.test.level27.lesson15.big01.statistic.event.NoAvailableVideoEventDataRow;

import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet  {

    private final int number;
    private static java.util.logging.Logger logger = Logger.getLogger(Tablet.class.getName());
    private LinkedBlockingQueue<Order> queue;

    public Tablet(int number) {
        this.number = number;
    }

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

    public void createOrder()  {

        Order order = null;
        try {
            order = new Order(this);
            processOrder(order);
        }catch (IOException e){
            logger.log(Level.SEVERE, "Console is unavailable.");
        } catch (NoVideoAvailableException novideo){
            StatisticEventManager.getInstance().register(new NoAvailableVideoEventDataRow(order.getTotalCookingTime() * 60));
            logger.log(Level.INFO, "No video is available for the order " + order);
        }
    }

    public void createTestOrder(){
        TestOrder order = null;
        try {
            order = new TestOrder(this);
            processOrder(order);
        }catch (IOException e){
            logger.log(Level.SEVERE, "Console is unavailable.");
        } catch (NoVideoAvailableException novideo){
            StatisticEventManager.getInstance().register(new NoAvailableVideoEventDataRow(order.getTotalCookingTime() * 60));
            logger.log(Level.INFO, "No video is available for the order " + order);
        }
    }

    private void processOrder(Order order) {
        if (!order.isEmpty()) {
            ConsoleHelper.writeMessage(order.toString());
            queue.offer(order);  // put order to queue for cooking ...
            new AdvertisementManager(order.getTotalCookingTime() * 60).processVideos();
        }
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }

}
