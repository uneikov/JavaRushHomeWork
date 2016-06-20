package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException{

        Scanner scanner = new Scanner(System.in);
        String fileName1 = scanner.nextLine();
        String fileName2 = scanner.nextLine();

        FileReader in = new FileReader(fileName1);
        FileWriter out = new FileWriter(fileName2);

        int ch;
        while (in.ready()){
            ch = in.read();
            if (ch == 46) ch = 33; // меняем "." на "!"
            out.write(ch);
        }
        scanner.close();
        in.close();
        out.close();
    }
}
