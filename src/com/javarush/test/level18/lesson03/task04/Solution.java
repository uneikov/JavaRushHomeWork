package com.javarush.test.level18.lesson03.task04;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws IOException
    {
        int first = 0;
        int count = 0;
        int idxNext = 0;

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> byteArray = new ArrayList<>();
        ArrayList<Integer> numArray = new ArrayList<>();

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
                    numArray.add(count);
                    count = 0;
                    idxNext = i;
                    break;
                }
                if (i == list.size()-1){
                    byteArray.add(first);
                    numArray.add(count);
                    idxNext = i+1;
                    break;
                }
            }
        }

        BubbleSort.bubbleSortForLinkedArrays(byteArray, numArray);
        printResult(byteArray, numArray);

        sc.close();
        in.close();
    }
    public static void printResult(ArrayList<Integer> ba, ArrayList<Integer> na){
        int small = na.get(ba.size()-1);
        System.out.print(ba.get(ba.size()-1) + " ");
        for (int i = ba.size()-2; i > 0; i--){
           if (na.get(i) == small) System.out.print(ba.get(i) + " ");
        }
    }
}
