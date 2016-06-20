package com.javarush.test.level18.lesson03.task02;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(new InputStreamReader(System.in));
        String fileName =sc.nextLine();
        FileInputStream in = new FileInputStream(fileName);
        int min = 255;
        while (in.available() > 0){
            int next = in.read();
            if (next < min) min = next;
        }
        System.out.println(min);
        sc.close();
        in.close();
    }
}
