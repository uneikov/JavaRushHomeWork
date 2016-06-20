package com.javarush.test.level08.lesson08.task01;

import java.util.HashSet;
import java.util.Set;

/* 20 слов на букву «Л»
Создать множество строк (Set<String>), занести в него 20 слов на букву «Л».
*/



public class Solution
{

    public static HashSet<String> createSet()
    {
        HashSet<String> list = new HashSet<>();
        list.add("Лук");
        list.add("Лок");
        list.add("Люк");
        list.add("Лик");
        list.add("Лак");
        list.add("Луч");
        list.add("Лупа");
        list.add("Лира");
        list.add("Лора");
        list.add("Ларнака");
        list.add("Лукака");
        list.add("Ликака");
        list.add("Лакака");
        list.add("Люкака");
        list.add("Лстпр");
        list.add("Льорп");
        list.add("Лглот");
        list.add("Лцвсцв");
        list.add("Лолдю");
        list.add("Лимум");
        return list;
    }
}
