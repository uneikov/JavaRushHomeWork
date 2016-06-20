package com.javarush.test.level19.lesson10.home09;

/* Контекстная реклама
В методе main подмените объект System.out написанной вами реадер-оберткой
Ваша реадер-обертка должна выводить на консоль контекстную рекламу после каждого второго println-а
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Рекламный текст: "JavaRush - курсы Java онлайн"

Пример вывода:
first
second
JavaRush - курсы Java онлайн
third
fourth
JavaRush - курсы Java онлайн
fifth
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        String ad = "JavaRush - курсы Java онлайн" + System.lineSeparator();
        String result = "", ads;
        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(bs);
        PrintStream old = System.out;

        System.setOut(ps);

        testString.printSomething();

        System.setOut(old);

        String[] s = bs.toString().split(System.lineSeparator());

        for (int i = 0; i < s.length; i ++ ) {
            ads = (i%2 != 0) ? ad : "";
            result +=  s[i] + System.lineSeparator() + ads;
        }

        System.out.print(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
