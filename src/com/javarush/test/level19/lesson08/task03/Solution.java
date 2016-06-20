package com.javarush.test.level19.lesson08.task03;

/* Выводим только цифры
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить только цифры
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток
Вывести модифицированную строку в консоль.

Пример вывода:
12345678
*/

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        OutputStream byteArrayToPrint = new ByteArrayOutputStream();
        PrintStream printStream= new PrintStream(byteArrayToPrint);
        PrintStream oldStream = new PrintStream(System.out);

        System.setOut(printStream);

        testString.printSomething();

        System.setOut(oldStream);

        String next;
        String toDigitize = byteArrayToPrint.toString();
        Scanner strScanner = new Scanner(toDigitize);
        while ((next = strScanner.findWithinHorizon("\\d+", toDigitize.length())) != null) System.out.print(next);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
