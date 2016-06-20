package com.javarush.test.level16.lesson13.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;

/* Клубок
1. Создай 5 различных своих нитей c отличным от Thread типом:
1.1. нить 1 должна бесконечно выполняться;
1.2. нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
1.3. нить 3 должна каждые полсекунды выводить "Ура";
1.4. нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. нить 5 должна читать с консоли цифры пока не введено слово "N", а потом вывести в консоль сумму введенных цифр.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.
Подсказка: Нить 4 можно проверить методом isAlive()
Это интересно!!!
ThreadFour t3 = (ThreadFour) threads.get(3);
t3.showWarning();
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<Thread>(5);
    static boolean isStopped = false;
    static {
        threads.add(new ThreadOne());
        threads.add(new ThreadTwo());
        threads.add(new ThreadThree());
        threads.add(new ThreadFour());
        threads.add(new ThreadFive());
    }
    public static void main(String[] args){
        for (Thread t : threads) t.start();

    }

    public static class ThreadOne extends Thread
    {
        public void run()
        {
            while(!isInterrupted()) {}
        }
    }
    public static class ThreadTwo extends Thread
    {
        public void run()
        {
            try
            {
                while (true) { Thread.sleep(100); }
            }catch (InterruptedException ex){System.out.println("InterruptedException");}
        }
    }
    public static class ThreadThree extends Thread
    {
        public void run()
        {
            try
            {
                while (true) { System.out.print("Ура");Thread.sleep(500);}
            }catch (InterruptedException ex){}
        }
    }
    public static class ThreadFour extends Thread implements Message
    {
        // это интересно!!
        public void run() {
            while (!isInterrupted());
        }

        public void showWarning(){
            interrupt();
            while (isAlive());
        }
    }
    public static class ThreadFive extends Thread
    {
        int sum = 0 ;
        String s ="";
        public void run() {
            try (BufferedReader r = new BufferedReader(new InputStreamReader(System.in)))
            {
                while (!isInterrupted())
                {
                    s = r.readLine();
                    if ("N".equals(s)) {
                        throw new InterruptedException();
                    }
                    else sum += Integer.parseInt(s);
                }
            }
            catch (IOException ex) {System.out.println("Ошибка ввода");}
            catch (InterruptedException ei) {System.out.println(sum);
            }

        }
    }
}
