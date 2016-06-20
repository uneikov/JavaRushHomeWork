package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

public class Solution {
    public static void main(String[] args) throws IOException{

            int spaceCount = 0;
            int allSym;
            ArrayList<Integer> list = new ArrayList<>();
            FileInputStream in = new FileInputStream(args[0]);

            while (in.available() > 0) list.add(in.read());
            allSym = list.size();

            for (Integer code : list) if(code == 32) spaceCount++;

            System.out.format(Locale.ENGLISH,"%.2f", 100*(float)spaceCount/(float) allSym);

            in.close();

    }
}
