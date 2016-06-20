package com.javarush.test.level19.lesson08.task05;

/* Дублируем текст
Считайте с консоли имя файла
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна дублировать вывод всего текста в файл, имя которого вы считали
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток
Закройте поток файла

Пример вывода на экран:
it's a text for testing

Пример тела файла:
it's a text for testing
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        FileWriter outFile = new FileWriter(new File(name));

        OutputStream byteArrayToPrint = new ByteArrayOutputStream();
        PrintStream printStream= new PrintStream(byteArrayToPrint);
        PrintStream oldStream = System.out;

        System.setOut(printStream);

        testString.printSomething();

        outFile.write(byteArrayToPrint.toString());

        System.setOut(oldStream);

        System.out.print(byteArrayToPrint.toString());

        outFile.close();
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

