package com.javarush.test.level26.lesson10.home02;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by URAN on 09.06.2016.
 */
public class Producer implements Runnable {
    protected ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    @Override
    public void run() {
        Thread currentThread = Thread.currentThread();
        try {
            int count = 1;
            while (true) {
                map.putIfAbsent(String.valueOf(count), "Some text for " + count++);
                Thread.sleep(500);
            }
        }catch (InterruptedException ex){
            System.out.println("[" + currentThread.getName() + "]" + " thread was terminated");
        }
    }
}
