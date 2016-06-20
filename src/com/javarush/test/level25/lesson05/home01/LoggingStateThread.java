package com.javarush.test.level25.lesson05.home01;

/**
 * Created by URAN on 02.06.2016.
 */
public class LoggingStateThread extends Thread
{
    private Thread target;
    private Thread.State last;

    public LoggingStateThread(Thread target)
    {
        this.target = target;
        this.last = target.getState();
        System.out.println(last); // иначе NEW не выводится
        setDaemon(true); // запуск в режиме демона - завершение после завершения всех нитей
    }

    @Override
    public void run()
    {
        Thread.State current;
        do
        {
            current = target.getState();
            if (current != last)
            {   // выводим только новые состояния
                System.out.println(target.getState());
                last = current;
            }
        }while (current != Thread.State.TERMINATED);
    }
}
