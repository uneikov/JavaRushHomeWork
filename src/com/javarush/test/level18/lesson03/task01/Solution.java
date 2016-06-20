package com.javarush.test.level18.lesson03.task01;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;


/* Максимальный байт
Ввести с консоли имя файла
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(new InputStreamReader(System.in));
        String fileName =sc.nextLine();
        FileInputStream in = new FileInputStream(fileName);
        int max = 0;
        while (in.available() > 0){
            int next = in.read();
            if (next > max) max = next;
        }
        System.out.println(max);
        sc.close();
        in.close();
    }
}
