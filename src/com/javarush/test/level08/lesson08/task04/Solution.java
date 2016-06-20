package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static void main(String [] args)
    {
        HashMap<String, Date> map = createMap();
        removeAllSummerPeople(map);
    }

    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();

        map.put("Stallone", new Date("Jun 1 1980"));
        map.put("Obama", new Date("May 15 1976"));
        map.put("Bon Jovi", new Date("Jan 3 1956"));
        map.put("Jimi Hendrix", new Date("Sep 23 1944"));
        map.put("John Lennon", new Date("Dec 12 1933"));
        map.put("Mahavishnu Shankar", new Date("May 15 1976"));
        map.put("Bill Hockins", new Date("Jun 1 1980"));
        map.put("Thin Lizzy", new Date("May 15 1976"));
        map.put("Rocky Balboa", new Date("Jun 1 1980"));
        map.put("Jorge Bush", new Date("May 15 1976"));

        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        HashMap<String, Date> copy = new HashMap<String, Date>(map);

        for (Map.Entry<String, Date> pair: copy.entrySet())
        {
            if (pair.getValue().getMonth()==5 ||  pair.getValue().getMonth()==6 || pair.getValue().getMonth()==7)
                map.remove(pair.getKey());
        }
    }


}
