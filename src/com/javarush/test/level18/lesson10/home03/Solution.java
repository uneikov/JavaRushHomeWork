package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        int count = 0;
        byte[] buffer;
        try
        {
            Scanner sc = new Scanner(new InputStreamReader(System.in));
            String joinedFileName = sc.nextLine();
            String inFileName1 = sc.nextLine();
            String inFileName2 = sc.nextLine();

            FileOutputStream jo = new FileOutputStream(joinedFileName);
            FileInputStream in1 = new FileInputStream(inFileName1);
            FileInputStream in2 = new FileInputStream(inFileName2);

            int fileSize1 = in1.available();
            int fileSize2 = in2.available();

            buffer = new byte[fileSize1];
            if (fileSize1 > 0) {
                count = in1.read(buffer);
                jo.write(buffer);
            }

            buffer = new byte[fileSize2];
            if (fileSize2 > 0) {
                count = in2.read(buffer);
                jo.write(buffer);
            }

            sc.close();
            jo.close();
            in1.close();
            in2.close();

        }catch (IOException ex) {}

    }
}
