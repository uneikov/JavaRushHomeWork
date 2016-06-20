package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


public class Solution {
    public static void main(String[] args) throws IOException {


        int first;
        int count = 0;
        int idxNext = 0;

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> byteArray = new ArrayList<>();
        ArrayList<Integer> numArray = new ArrayList<>();


        FileInputStream in = new FileInputStream(args[0]);

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

        in.close();
    }
    public static void printResult(ArrayList<Integer> ba, ArrayList<Integer> na){

        for (int i = 0; i < ba.size(); i++){
            System.out.println((char)((int)ba.get(i)) + " " + na.get(i));
        }
    }
}
