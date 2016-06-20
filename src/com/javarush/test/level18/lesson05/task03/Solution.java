package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        int count = 0;
        int part1;
        int part2;
        try
        {
            Scanner sc = new Scanner(new InputStreamReader(System.in));
            String inFileName = sc.nextLine();
            String outFileName1 = sc.nextLine();
            String outFileName2 = sc.nextLine();
            FileInputStream in = new FileInputStream(inFileName);
            FileOutputStream out1 = new FileOutputStream(outFileName1);
            FileOutputStream out2 = new FileOutputStream(outFileName2);

            int fileSize = in.available();
            if (fileSize > 0) {
                part2 = fileSize/2;
                part1 = fileSize - part2;
                byte[] buffer = new byte[fileSize];
                count = in.read(buffer);
                out1.write(buffer, 0, part1);
                out2.write(buffer, part1, part2);
            }

            sc.close();
            in.close();
            out1.close();
            out2.close();

        }catch (IOException ex) {}

    }
}
