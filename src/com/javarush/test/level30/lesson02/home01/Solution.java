package com.javarush.test.level30.lesson02.home01;

import java.math.BigInteger;
import java.util.Stack;

/* Конвертер систем счислений
Реализуйте логику метода convertNumberToOtherNumerationSystem, который должен переводить число number.getDigit()
из одной системы счисления(numerationSystem) в другую (expectedNumerationSystem)
бросьте NumberFormatException, если переданное число некорректно, например, число "120" с системой счисления 2
Валидация для - number.getDigit() - целое не отрицательное
Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        Number number = new Number(NumerationSystemType._9, "-1126657201");
        Number result = convertNumberToOtherNumerationSystem(number, NumerationSystemType._16);
        System.out.println(result);    //expected 110
    }

    public static Number convertNumberToOtherNumerationSystem(Number number, NumerationSystem expectedNumerationSystem) {

        BigInteger bigInteger = new BigInteger(number.getDigit(), number.getNumerationSystem().getNumerationSystemIntValue());

        String str = bigInteger.toString(expectedNumerationSystem.getNumerationSystemIntValue());

        return new Number(expectedNumerationSystem, str);
    }
/*
    public static Number convertNumberToOtherNumerationSystem(Number number, NumerationSystem expectedNumerationSystem) {

        Stack<String> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        String sign = "";

        int head = Integer.parseInt(convertToDecimalSystem(number));
        if (head < 0){
            head = -head;
            sign = "-";
        }
        int base = expectedNumerationSystem.getNumerationSystemIntValue();
        int tail;

        do {
            if (head < base) break;
            tail = head % base;
            stack.push(getASCIIDigit(tail));
            head /= base;
        } while (!(head < base));

        stack.add(getASCIIDigit(head));

        while (!stack.empty()) result.append(stack.pop());
        result.insert(0, sign);

        return new Number(expectedNumerationSystem , result.toString());

    }

    public static String getASCIIDigit(int value){
        if (value > 9) return "" + (char) (value % 10 + 97);
        else return "" + value;
    }

    public static String convertToDecimalSystem(Number number) {
        String decimalSystemValueAsAString;
        String num = number.getDigit();
        int base = number.getNumerationSystem().getNumerationSystemIntValue();
        decimalSystemValueAsAString = Integer.toString(Integer.parseInt(num, base));
        return decimalSystemValueAsAString;
    }
*/
}
