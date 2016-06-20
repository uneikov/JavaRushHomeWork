package com.javarush.test.level10.lesson11.home08;

import java.util.ArrayList;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<String>[] arrayOfStringList =  createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList()
    {
        ArrayList<String>[] arrayOfStringList = new ArrayList[3];

        ArrayList<String> stringList1 = new ArrayList<>();
        ArrayList<String> stringList2 = new ArrayList<>();
        ArrayList<String> stringList3 = new ArrayList<>();

        stringList1.add("1-Мама мыла раму");
        stringList1.add("1-Curly Poorly");
        stringList1.add("1-Persepolis");

        stringList2.add("2-Мама мыла раму");
        stringList2.add("2-Curly Poorly");
        stringList2.add("2-Persepolis");

        stringList3.add("3-Мама мыла раму");
        stringList3.add("3-Curly Poorly");
        stringList3.add("3-Persepolis");

        arrayOfStringList[0] = stringList1;
        arrayOfStringList[1] = stringList2;
        arrayOfStringList[2] = stringList3;

        return arrayOfStringList;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        for (ArrayList<String> list: arrayOfStringList)
        {
            for (String s : list)
            {
                System.out.println(s);
            }
        }
    }
}