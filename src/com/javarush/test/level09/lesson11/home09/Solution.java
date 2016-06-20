package com.javarush.test.level09.lesson11.home09;

import java.util.*;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap()
    {
        Map<String, Cat> catMap = new HashMap<>();
        catMap.put("Basil",new Cat("Basil"));
        catMap.put("Murka",new Cat("Murka"));
        catMap.put("S1T2",new Cat("S1T2"));
        catMap.put("btre",new Cat("btre"));
        catMap.put("Lisp",new Cat("Lisp"));
        catMap.put("Ada",new Cat("Ada"));
        catMap.put("Fortran",new Cat("Fortran"));
        catMap.put("C++",new Cat("C++"));
        catMap.put("C#",new Cat("C#"));
        catMap.put("php",new Cat("php"));
        return catMap;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map)
    {
        Iterator<Map.Entry<String, Cat>> iterator = map.entrySet().iterator();
        Set<Cat> catSet = new HashSet<>();
        while (iterator.hasNext())
        {
            Map.Entry<String, Cat> pair = iterator.next();
            catSet.add(pair.getValue());
        }
        return catSet;
    }

    public static void printCatSet(Set<Cat> set)
    {
        for (Cat cat:set)
        {
            System.out.println(cat);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat "+this.name;
        }
    }


}
