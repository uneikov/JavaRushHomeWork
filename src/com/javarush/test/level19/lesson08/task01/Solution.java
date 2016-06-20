package com.javarush.test.level19.lesson08.task01;

/* Ридер обертка
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна преобразовывать весь текст в заглавные буквы
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток.
Вывести модифицированную строку в консоль.
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException{

        OutputStream byteArrayToPrint = new ByteArrayOutputStream();
        PrintStream printStream= new PrintStream(byteArrayToPrint);
        PrintStream oldStream = new PrintStream(System.out);

        System.setOut(printStream);

        testString.printSomething();

        System.setOut(oldStream);

        System.out.println(byteArrayToPrint.toString().toUpperCase());
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
