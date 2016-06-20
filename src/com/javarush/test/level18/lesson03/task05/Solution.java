package com.javarush.test.level18.lesson03.task05;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;




/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws IOException
    {
        int first = 0;
        int count = 0;
        int idxNext = 0;

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> byteArray = new ArrayList<>();

        Scanner sc = new Scanner(new InputStreamReader(System.in));
        String fileName =sc.nextLine();

        FileInputStream in = new FileInputStream(fileName);

        while (in.available() > 0) list.add(in.read());

        Collections.sort(list);

        while (idxNext < list.size())
        {
            first = list.get(idxNext);
            for (int i = idxNext; i < list.size(); i++)
            {
                if (list.get(i) == first) count++;
                else
                {
                    byteArray.add(first);
                    count = 0;
                    idxNext = i;
                    break;
                }
                if (i == list.size()-1){
                    byteArray.add(first);
                    idxNext = i+1;
                    break;
                }
            }
        }

        printResult(byteArray);

        sc.close();
        in.close();
    }
    public static void printResult(ArrayList<Integer> ba){
        for (int i = 0; i < ba.size(); i++){
            System.out.print(ba.get(i) + " ");
        }
    }
}
