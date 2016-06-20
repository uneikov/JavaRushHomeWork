package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String fileName1 = scanner.nextLine();
        String fileName2 = scanner.nextLine();

        int count = 1;
        try
        {
            FileInputStream in = new FileInputStream(fileName1);
            FileOutputStream out = new FileOutputStream(fileName2);

            while (in.available()>0){ // первый байт (с номером 0) четный?
                byte f = (byte) in.read();
                if (count%2 == 0) out.write(f);
                count++;
            }
            scanner.close();
            in.close();
            out.close();

        }catch (IOException ex){}
    }
}
