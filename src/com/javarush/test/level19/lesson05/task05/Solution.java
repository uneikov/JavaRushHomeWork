package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, включая символы новой строки. Результат вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException{

        String inputString, next = "";
        Pattern toDelete = Pattern.compile("[ _\"'`,.;:?!(){}\\[\\]<>\\s\\-]");

        Scanner scanner = new Scanner(System.in);
        String fileName1 = scanner.nextLine();
        String fileName2 = scanner.nextLine();

        BufferedReader in = new BufferedReader(new FileReader(fileName1));
        FileWriter out = new FileWriter(fileName2);

        while ((inputString = in.readLine()) != null){

            Scanner strScanner = new Scanner(inputString);
            strScanner.useDelimiter(toDelete); // используем разделитель любой знак препинания
            if (strScanner.hasNext()) next = strScanner.next();
            while (strScanner.hasNext()){ // сканер читает слова выбрасывая раделители
                next +=strScanner.next(); // собираем строку
            }

            out.write(next);
            strScanner.close();

        }

        scanner.close();
        in.close();
        out.close();
    }
}
