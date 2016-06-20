package com.javarush.test.level07.lesson06.task01;

import java.util.ArrayList;

/* 5 различных строчек в списке
1. Создай список строк.
2. Добавь в него 5 различных строчек.
3. Выведи его размер на экран.
4. Используя цикл выведи его содержимое на экран, каждое значение с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<String> as = new ArrayList<>();
        as.add("шаркающей");
        as.add("кавалерийской");
        as.add("походкой");
        as.add("14 числа весеннего месяца ниссана");
        System.out.println(as.size());
        for(Object e : as) System.out.println(e);
    }
}
