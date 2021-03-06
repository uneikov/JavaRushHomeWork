package com.javarush.test.level09.lesson02.task05;

/* Метод должен возвращать результат – глубину его стек-трейса
Написать метод, который возвращает результат – глубину его стек трейса – количество методов в нем (количество элементов в списке). Это же число метод должен выводить на экран.
*/

public class Solution
{
    public static int getStackTraceDeep()
    {
        int count = 0;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (;;){
            if (!(stackTrace[count].getMethodName()).equals("main")) count++;
            else { count++; break;}
        }
        System.out.println(count);
        return count;
    }
}
