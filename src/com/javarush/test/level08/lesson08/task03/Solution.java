package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{

    public static void main(String[] args)
    {
        System.out.println(getCountTheSameFirstName(createMap(), "Сергей"));
        System.out.println(getCountTheSameLastName(createMap(), "Николаев"));
    }

    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> map = new HashMap<>();
        map.put("Иванов", "Сергей");
        map.put("Сергеев", "Петр");
        map.put("Илларионов", "Василий");
        map.put("Гуридзе", "Автандил");
        map.put("Патагонов", "Трофим");
        map.put("Лагидзе", "Анатолий");
        map.put("Николаев", "Юрий");
        map.put("Сванидзе", "Николай");
        map.put("Ивановский", "Владимир");
        map.put("Василевский", "Сергей");
        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String firstName)
    {
        int result =0;

        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();

        while (iterator.hasNext())
        {
            Map.Entry<String, String> pair = iterator.next();
            if (pair.getValue().equals(firstName)) result++;
        }
        return result;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName)
    {
        int result =0;

        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();

        while (iterator.hasNext())
        {
            Map.Entry<String, String> pair = iterator.next();
            if (pair.getKey().equals(lastName)) result++;
        }
        return result;
    }
}
