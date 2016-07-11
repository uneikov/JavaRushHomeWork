package com.javarush.test.level30.lesson04.home01;

import java.sql.Time;
import java.util.concurrent.TransferQueue;

/**
 * Created by URAN on 10.07.2016.
 */
public class Consumer implements Runnable {
    private TransferQueue<ShareItem> queue;

    public Consumer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        if (!Thread.currentThread().isInterrupted()){
            try {
                Thread.sleep(500);
                while (true){
                    System.out.println("Processing " + queue.take());
                }
            }catch (InterruptedException ex) {}
        }
    }
}
