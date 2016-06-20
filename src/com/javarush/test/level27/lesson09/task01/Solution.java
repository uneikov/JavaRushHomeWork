package com.javarush.test.level27.lesson09.task01;

import java.util.concurrent.CountDownLatch;

/* CountDownLatch
Дана стандартная реализация методологии wait-notify.
Почитайте про CountDownLatch и перепишите тело метода someMethod используя поле latch.
Весь лишний код удалите из класса.
*/

public abstract class Solution {

    private final CountDownLatch latch = new CountDownLatch(1);

    public void someMethod() throws InterruptedException {
        latch.await(); // waiting ... for value
        retrieveValue();  // get value
        latch.countDown();  // release latch (latch initialised with value 1) //
    }

    abstract void retrieveValue();
}

/*
было так...
public abstract class Solution {
    private final Object lock = new Object();
    private volatile boolean isWaitingForValue = true;

    private final CountDownLatch latch = new CountDownLatch(1);

    public void someMethod() throws InterruptedException {
        synchronized (lock) {
            while (isWaitingForValue) {
                lock.wait();
            }
        }

        //latch.await();

        retrieveValue();

        isWaitingForValue = false;
        lock.notify();
    }

    abstract void retrieveValue();
}
*/