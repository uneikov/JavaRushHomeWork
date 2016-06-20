package com.javarush.test.level25.lesson05.task01;

/* Switch для нитей
Обработайте список нитей в зависимости от состояния:
1. Если нить еще не запущена, то запустите ее.
2. Если нить в ожидании, то прервите ее.
3. Если нить работает, то проверить маркер isInterrupted.
4. Если нить прекратила работу, то выведите в консоль ее приоритет.
Используйте switch.
*/
public class Solution {
    public static void processThreads(Thread... threads) {

        for (Thread thrd : threads){
            switch (thrd.getState()){
                case NEW: { thrd.start(); break;}
                case RUNNABLE: {if (thrd.isInterrupted()){ thrd.start(); break; }}
                case BLOCKED: { thrd.interrupt(); break; }
                case WAITING: { thrd.interrupt();  break; }
                case TIMED_WAITING: { thrd.interrupt();  break; }
                case TERMINATED: { System.out.println(thrd.getPriority()); break; }

            }
        }
        //implement this method - реализуйте этот метод
    }
}
