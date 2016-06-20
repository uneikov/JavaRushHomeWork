package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        OutputStream byteArrayToPrint = new ByteArrayOutputStream();
        PrintStream printStream= new PrintStream(byteArrayToPrint);
        PrintStream oldStream = new PrintStream(System.out);

        System.setOut(printStream);

        testString.printSomething();

        System.setOut(oldStream);

        int result = 0;
        String[] parts = byteArrayToPrint.toString().split(" ");
        int op1 = Integer.parseInt(parts[0]);
        int op2 = Integer.parseInt(parts[2]);
        String  sign = parts[1];
        if (sign.equals("-")) {
            result = op1 - op2;
        }else if(sign.equals("+")) {
            result = op1 + op2;
        }else if(sign.equals("*")) {
            result = op1 * op2;
        }

        System.out.println(op1 + " " + sign + " " + op2 + " = " + result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}
