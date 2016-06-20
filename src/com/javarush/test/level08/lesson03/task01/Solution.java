package com.javarush.test.level08.lesson03.task01;

/* HashSet из растений
Создать коллекцию HashSet с типом элементов String.
Добавить в неё 10 строк: арбуз, банан, вишня, груша, дыня, ежевика, жень-шень, земляника, ирис, картофель.
Вывести содержимое коллекции на экран, каждый элемент с новой строки.
Посмотреть, как изменился порядок добавленных элементов.
*/

import java.util.HashSet;
import java.util.Set;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        Set<String> plant = new HashSet<>();
        plant.add("арбуз");
        plant.add("банан");
        plant.add("вишня");
        plant.add("груша");
        plant.add("дыня");
        plant.add("ежевика");
        plant.add("жень-шень");
        plant.add("земляника");
        plant.add("ирис");
        plant.add("картофель");
        for (String p : plant) System.out.println(p);
    }
}
