package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки. Не использовать try-with-resources

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        int count = 0;
        try
        {
            Scanner sc = new Scanner(new InputStreamReader(System.in));
            String fileName = sc.nextLine();
            FileInputStream in = new FileInputStream(fileName);

            while (in.available() > 0){
                if (in.read() == 44) count++;
            }
            System.out.println(count);
            sc.close();
            in.close();
        }catch (IOException ex) {}

    }
}
