package com.javarush.test.level08.lesson08.task02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* Удалить все числа больше 10
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.
*/

public class Solution
{

    public static HashSet<Integer> createSet()
    {
        HashSet<Integer> list = new HashSet<>();
        list.add(1);
        list.add(11);
        list.add(221);
        list.add(132);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(112);
        list.add(113);
        list.add(114);
        list.add(115);
        list.add(116);
        list.add(11111);
        list.add(117);
        list.add(1128);
        list.add(133);
        list.add(154);
        return list;
    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set)
    {
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext())
        {
            if (iterator.next() > 10) iterator.remove();
        }
        return set;
    }
}
