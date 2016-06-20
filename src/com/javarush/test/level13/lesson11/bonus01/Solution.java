package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.*;

public class Solution
{
    public static void main(String[] args)
    {
        String fileName = "";
        List<Integer> inputList = new LinkedList<>();
        List<Integer> outList = new LinkedList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
        fileName = reader.readLine();}
        catch (Exception ex) {}

        try
        {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextInt()) inputList.add(scanner.nextInt());
        } catch (Exception ex){}

        for (Integer o : inputList)if(o%2==0) outList.add(o);

        Collections.sort(outList);

        for (Integer o : outList)System.out.println(o);
    }
}
