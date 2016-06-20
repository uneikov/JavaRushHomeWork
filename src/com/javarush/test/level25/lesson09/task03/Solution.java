package com.javarush.test.level25.lesson09.task03;

import java.util.ArrayList;

/* Живем своим умом
В классе Solution реализуйте интерфейс UncaughtExceptionHandler, который должен:
1. прервать нить, которая бросила исключение.
2. вывести в консоль стек исключений начиная с самого вложенного.
Пример исключения: new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")))
Пример вывода:
java.lang.IllegalAccessException: GHI
java.lang.RuntimeException: DEF
java.lang.Exception: ABC
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e)
    {
        t.interrupt();
        // разбираем вложенные исключения (chained exception)
        ArrayList<Throwable> exChain = new ArrayList<>();
        exChain.add(e);

        Throwable nextChain = e.getCause();
        do
        {
            if (nextChain != null)
            {
                exChain.add(nextChain);
                nextChain = nextChain.getCause();
            }
        }while (nextChain != null);

        for (int i = exChain.size() - 1; i >= 0; i--) System.out.println(exChain.get(i).toString());

    }
}
