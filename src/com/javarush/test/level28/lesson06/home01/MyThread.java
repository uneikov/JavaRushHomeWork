package com.javarush.test.level28.lesson06.home01;


import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread{

    private static final AtomicInteger priority = new AtomicInteger(1);

    public MyThread() {
        setPriority();
    }

    public MyThread(Runnable target) {
        super(target);
        setPriority();
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        setPriority();
    }

    public MyThread(String name) {
        super(name);
        setPriority();
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        setPriority();

    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        setPriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        setPriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        setPriority();
    }

    private void setPriority(){
        priority.compareAndSet(MAX_PRIORITY + 1, MIN_PRIORITY); // compare AtomicInteger not simple task
        this.setPriority(priority.getAndIncrement()); // this !!! not Thread.currentThread() !!!
    }
}
