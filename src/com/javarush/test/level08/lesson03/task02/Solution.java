package com.javarush.test.level08.lesson03.task02;

/* HashMap из 10 пар
Создать коллекцию HashMap<String, String>, занести туда 10 пар строк:
арбуз - ягода, банан - трава, вишня - ягода, груша - фрукт, дыня - овощ, ежевика - куст, жень-шень - корень, земляника - ягода, ирис - цветок, картофель - клубень.
Вывести содержимое коллекции на экран, каждый элемент с новой строки.
Пример вывода (тут показана только одна строка):
картофель - клубень
*/

import java.util.HashMap;
import java.util.Map;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        Map<String, String> plant = new HashMap<String, String>();
        plant.put("арбуз", "ягода");
        plant.put("банан", "трава");
        plant.put("вишня", "ягода");
        plant.put("груша", "фрукт");
        plant.put("дыня", "овощ");
        plant.put("ежевика", "куст");
        plant.put("жень-шень", "корень");
        plant.put("земляника", "ягода");
        plant.put("ирис", "цветок");
        plant.put("картофель", "клубень");
        for (Map.Entry<String, String> pair : plant.entrySet())
        {
            String key = pair.getKey();
            String value = pair.getValue();
            System.out.println(key + " - " + value);
        }
    }
}
