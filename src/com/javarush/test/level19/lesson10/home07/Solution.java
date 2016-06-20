package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{

        String  next, basket = "";
        String[] line;
        BufferedReader strReader = new BufferedReader(new FileReader(new File(args[0])));
        FileWriter strWriter = new FileWriter(new File(args[1]));

        while ((next = strReader.readLine()) != null){
            line = next.split(" ");
            for (String s : line){
                if ( s.length() > 6) basket += s + ",";
            }
        }
        strWriter.write(basket.substring(0, basket.length()-1));

        strReader.close();
        strWriter.close();
    }
}
