package com.javarush.test.level20.lesson10.bonus01;

import java.util.ArrayList;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {

    public static int[] getNumbers(int N) {

        int[] powerArray = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        ArrayList<Integer> armstrong = new ArrayList<>();
        int[] result;
        int[] input;
        char[] charArray;
        int oldLength = 1;
        int sum = 0;

        for (int n = 1; n < N; n++)
        {   // формируем массив из цифр, составляющих входное число
            charArray = String.valueOf(n).toCharArray();
            input = new int[charArray.length];
            for (int i = 0; i < charArray.length; i++) input[i] = Character.getNumericValue(charArray[i]);
            // при переходе на следующий порядок уточняем список степеней цифр входного числа
            if (oldLength < input.length) for (int i = 2; i < 10; i++) powerArray[i] *= i;
            // находи сумму степеней и сравниваем с входным числом
            for (int i = 0; i < input.length; i++)  sum += powerArray[input[i]];
            if (n == sum) armstrong.add(n);
            // подготовка к следующему циклу
            oldLength = input.length;
            sum = 0;
        }
        result = new int[armstrong.size()];
        for(int i=0;i<armstrong.size();i++){
            result[i]=armstrong.get(i);
        }
        return result;
    }
}
