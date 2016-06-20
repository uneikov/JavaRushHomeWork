package com.javarush.test.level08.lesson08.task05;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static void main(String[] args)
    {
        HashMap<String, String> map;
        map =createMap();
        removeTheFirstNameDuplicates(map);
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

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map); // создаем копию карты
        for (Map.Entry<String, String> pair: copy.entrySet()) // выбираем образец для сравнения из копии
        {
        if(getCountTheSameFirstName(map, pair.getValue()) > 1) removeItemFromMapByValue(map, pair.getValue());
        }
    } // если есть дубликаты, они удаляются из исходнного массива

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

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);

        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
// Фишка в том, чтобы создать копию массива и выбирать элементы для сравнения из него, а операции
// совершать над исходным массивом