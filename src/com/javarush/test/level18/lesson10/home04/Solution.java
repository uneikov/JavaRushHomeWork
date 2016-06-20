package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        byte[] buffer1, buffer2, joinedArray;
        try
        {
            Scanner sc = new Scanner(new InputStreamReader(System.in));
            String inFileName1 = sc.nextLine();
            String inFileName2 = sc.nextLine();

            FileInputStream in1 = new FileInputStream(inFileName1);
            FileInputStream in2 = new FileInputStream(inFileName2);

            int fileSize1 = in1.available();
            int fileSize2 = in2.available();

            buffer1 = new byte[fileSize1];
            if (fileSize1 > 0) in1.read(buffer1);
            in1.close();
            buffer2 = new byte[fileSize2];
            if (fileSize2 > 0)in2.read(buffer2);
            in2.close();

            FileOutputStream jo = new FileOutputStream(inFileName1);

            joinedArray = new byte[fileSize1 + fileSize2];

            System.arraycopy(buffer2, 0, joinedArray, 0, fileSize2);
            System.arraycopy(buffer1, 0, joinedArray, fileSize2, fileSize1);
            jo.write(joinedArray);

            sc.close();
            jo.close();

        }catch (IOException ex) {}
    }
}
