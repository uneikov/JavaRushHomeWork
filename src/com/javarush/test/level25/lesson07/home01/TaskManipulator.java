package com.javarush.test.level25.lesson07.home01;

public class TaskManipulator implements Runnable, CustomThreadManipulator {

    private String threadName;
    private Thread thread;
    private static int count = 0;

    @Override

    public void run() {
        try {
            while (!thread.isInterrupted()) {
                thread.sleep(0); // а это ваще бред
                System.out.println(threadName);
                thread.sleep(90); // этот бред - подбирается !
            }
        } catch (InterruptedException e) {}
    }

    @Override
    public void start(String threadName)
    {
        this.threadName = threadName;
        this.thread = new Thread(this, threadName);
        thread.start();
    }

    @Override
    public void stop()
    {
        thread.interrupt();
    }
}
