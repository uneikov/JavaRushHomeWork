package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
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
        try
        {
            Scanner sc = new Scanner(new InputStreamReader(System.in));
            String inFileName = sc.nextLine();
            String outFileName = sc.nextLine();
            FileInputStream in = new FileInputStream(inFileName);
            FileOutputStream out = new FileOutputStream(outFileName);

            int fileSize = in.available();
            if (fileSize > 0) {
                byte[] buffer = new byte[fileSize];
                count = in.read(buffer);
                reverseByteArray(buffer);
                out.write(buffer);
            }

            sc.close();
            in.close();
            out.close();


        }catch (IOException ex) {}
    }
    public static void reverseByteArray(byte[] byteArray)
    {
        int max_idx = byteArray.length;
        for (int idx =0; idx < max_idx/2; idx++)
        {
            byte tempByte = byteArray[idx];
            byteArray[idx] = byteArray[max_idx-idx-1];
            byteArray[max_idx-idx-1] = tempByte;

        }
    }
}
