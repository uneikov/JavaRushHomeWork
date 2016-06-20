package com.javarush.test.level18.lesson03.task03;

import java.io.*;
import java.util.*;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {

    public static void main(String[] args) throws IOException {
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
        int big = na.get(0);
        System.out.print(ba.get(0) + " ");
        for (int i = 1; i < ba.size(); i++){
            if (na.get(i) == big) System.out.print(ba.get(i) + " ");
        }
    }
}
