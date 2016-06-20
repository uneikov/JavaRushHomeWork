package com.javarush.test.level27.lesson06.task02;

import com.sun.xml.internal.bind.v2.util.ByteArrayOutputStreamEx;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/* Определяем порядок захвата монитора. Сложная.
Реализуйте логику метода isNormalLockOrder, который должен определять:
соответствует ли порядок synchronized блоков в методе someMethodWithSynchronizedBlocks - порядку
передаваемых в него аргументов. Должно выполняться условие:
для разных объектов o1 и o2 isNormalLockOrder(o1, o2) != isNormalLockOrder(o2, o1), для одинаковых объектов одинаковый результат
Метод main не участвует в тестировании.
*/
public class Solution {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        //следующие 4 строки в тестах имеют другую реализацию
        int lock1 = obj1.hashCode();
        int lock2 = obj2.hashCode();
        Object firstLock = lock1 > lock2 ? obj1 : obj2;
        Object secondLock = lock1 > lock2 ? obj2 : obj1;

        synchronized (firstLock) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ignored) {
                ignored.printStackTrace();
            }

            synchronized (secondLock) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    public static boolean isNormalLockOrder(final Solution solution, final Object o1, final Object o2) throws Exception {
        boolean result;
        /*
        solution.someMethodWithSynchronizedBlocks(o1, o2);

        Method[] methods = solution.getClass().getDeclaredMethods();
        Class[] types = methods[0].getParameterTypes();
        System.out.println(o1.toString() + " ---- " + o2.toString());
        Parameter[] parameters = solution.getClass().getDeclaredMethods()[0].getParameters();
        System.out.println(methods[0].getName() + " - " + parameters[0].getClass() + " - " + parameters[1].getClass());
        if (parameters[0].hashCode() == o1.hashCode() && parameters[1].hashCode() == o2.hashCode()) result = true;
        else result = false;
        System.out.println(result);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;

        System.setOut(ps);
        */
        solution.someMethodWithSynchronizedBlocks(o1, o2);
        //System.out.flush();


        //System.setOut(old);

        //System.out.println("Here: " + baos.toString());

        return true;
    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        new Thread() {
            @Override
            public void run() {
                try {
                    isNormalLockOrder(solution, o1, o2); //expected boolean b
                } catch (Exception ignored) {
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                try {
                    isNormalLockOrder(solution, o2, o1); //expected boolean !b
                } catch (Exception ignored) {
                }
            }
        }.start();

    }
}
