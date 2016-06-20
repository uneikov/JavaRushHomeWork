package com.javarush.test.level18.lesson10.home09;

/* Файлы и исключения
Читайте с консоли имена файлов
Если файла не существует (передано неправильное имя файла), то
перехватить исключение FileNotFoundException, вывести в консоль переданное неправильное имя файла и завершить работу программы.
Закрыть потоки. Не использовать try-with-resources
Не используйте System.exit();
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException{

        String name = "";
        boolean isInterrupted = false;
        FileInputStream file = null;
        Scanner scan = new Scanner(System.in);

        try {

            for (;;) {
                name = scan.nextLine();
                file = new FileInputStream(name);
            }

        }catch (FileNotFoundException ex) {

            System.out.println(name);
            isInterrupted = true;
        }

        scan.close();
        if (!isInterrupted) file.close();

    }
}
