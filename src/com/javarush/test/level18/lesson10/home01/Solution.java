package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
C:/Users/URAN/Desktop/result/txt
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;


public class Solution {
    public static void main(String[] args) throws IOException
    {
        int count = 0;
        ArrayList<Integer> list = new ArrayList<>();
        FileInputStream in = new FileInputStream(args[0]);

        while (in.available() > 0) list.add(in.read());

        for (Integer code : list){
            if(code >= 65 && code <=90 || code >= 97 && code <= 122) count++;
        }

        System.out.println(count);

        in.close();
    }
}
