package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException{

        int count = 0;
        Pattern delimiter = Pattern.compile("[ _\"'`,.;:?!(){}\\[\\]<>\\s\\-]");

        Scanner consoleScanner = new Scanner(System.in);
        String file = consoleScanner.nextLine();

        Scanner fileScanner = new Scanner(new File(file));
        fileScanner.useDelimiter(delimiter);

        while (fileScanner.hasNext()) if ("world".equals(fileScanner.next())) count++;

        System.out.println(count);

        consoleScanner.close();
        fileScanner.close();

    }
}
