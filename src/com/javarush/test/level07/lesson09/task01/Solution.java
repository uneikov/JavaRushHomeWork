package com.javarush.test.level07.lesson09.task01;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Три массива
1. Введи с клавиатуры 20 чисел, сохрани их в список и рассортируй по трём другим спискам:
Число делится на 3 (x%3==0), делится на 2 (x%2==0) и все остальные.
Числа, которые делятся на 3 и на 2 одновременно, например 6, попадают в оба списка.
2. Метод printList должен выводить на экран все элементы списка с новой строки.
3. Используя метод printList выведи эти три списка на экран. Сначала тот, который для x%3, потом тот, который для x%2, потом последний.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        Integer d = 0;
        ArrayList<Integer> intArray = new ArrayList<Integer>();
        ArrayList<Integer> threeArray = new ArrayList<Integer>();
        ArrayList<Integer> twoArray = new ArrayList<Integer>();
        ArrayList<Integer> allArray = new ArrayList<Integer>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 20; i++)
        {
            intArray.add(Integer.parseInt(br.readLine()));
        }
        for (int i = 0; i < 20; i++)
        {
            d = intArray.get(i);
            if ( d%3 == 0 ) threeArray.add(d);
            if ( d%2 == 0 ) twoArray.add(d);
            if ( d%3 != 0 && d % 2 != 0 ) allArray.add(d);
        }
        printList(threeArray);
        printList(twoArray);
        printList(allArray);
    }

    public static void printList(List<Integer> list)
    {
        for (Integer e : list) System.out.println(e + " ");
    }
}
