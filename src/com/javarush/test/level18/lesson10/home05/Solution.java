package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {

        String result = "";
        ArrayList<Double> list = new ArrayList<>();

        Scanner sc = new Scanner(new InputStreamReader(System.in));
        String inFileName = sc.nextLine();
        String outFileName = sc.nextLine();

        Scanner in = new Scanner(new File(inFileName)).useLocale(Locale.ENGLISH);
        while (in.hasNextDouble()) list.add(in.nextDouble());


        result += Math.round(list.get(0));
        for (int i = 1; i < list.size(); i ++) result += (" " + Math.round(list.get(i)));

        FileOutputStream out = new FileOutputStream(outFileName);
        out.write(result.getBytes());

        sc.close();
        in.close();
        out.close();
    }
}
