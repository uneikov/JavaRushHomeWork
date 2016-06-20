package com.javarush.test.level27.lesson04.task02;

/* Второй вариант дедлока
В методе secondMethod в синхронизированных блоках расставьте локи так,
чтобы при использовании класса Solution нитями образовывался дедлок
*/
public class Solution {
    private final Object lock = new Object();

    public synchronized void firstMethod() {
        synchronized (lock) {
            doSomething();
        }
    }

    public void secondMethod() {
        synchronized (lock) { // append here
            synchronized (this) { // and here
                doSomething();
            }
        }
    }

    private void doSomething() {

    }
}
// по факту добиться блокировки не удалось - возможно на больших промежутках времени получится ?