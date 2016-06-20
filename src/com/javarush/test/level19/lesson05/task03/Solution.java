package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;


public class Solution {

    public static void main(String[] args) throws IOException{

        boolean first = true;
        Scanner scanner = new Scanner(System.in);
        String fileName1 = scanner.nextLine();
        String fileName2 = scanner.nextLine();

        Scanner in = new Scanner(new File(fileName1));
        FileOutputStream out = new FileOutputStream(fileName2);

        while (in.hasNext()) {
            String mayBeANumber = in.next();
            if (isNumber(mayBeANumber)) {
                if (first) {out.write((mayBeANumber).getBytes()); first = false;}
                else out.write((" " + mayBeANumber).getBytes());
            }
        }

        scanner.close();
        in.close();
        out.close();
    }
    public static boolean isNumber(String s){
        boolean result;
        try{
            Scanner stringScanner= new Scanner(s);
            stringScanner.next("[0-9]+");
            result = true;
            stringScanner.close();
        }catch (Exception ex){
            result = false;
        }
        return result;
    }
}
