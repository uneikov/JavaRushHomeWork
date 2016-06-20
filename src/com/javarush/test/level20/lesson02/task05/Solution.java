package com.javarush.test.level20.lesson02.task05;

import java.io.*;
import java.util.Scanner;

/* И еще раз о синхронизации
Разберитесь почему не работает метод main()
Реализуйте логику записи в файл и чтения из файла для класса Object
Метод load должен инициализировать объект данными из файла
Метод main реализован только для вас и не участвует в тестировании
*/

public class Solution {
    // см. сигнатуру метода main!!!!!!!!!!!!!!!!
    public static void main(java.lang.String[] args) {
        try {
            File your_file_name = File.createTempFile("test", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Object object = new Object();
            object.string1 = new String();   //string #1
            object.string2 = new String();   //string #2
            object.string1.print();
            object.string2.print();

            object.save(outputStream);
            outputStream.flush();

            Object loadedObject = new Object();
            loadedObject.string1 = new String(); //string #3
            loadedObject.string2 = new String(); //string #4


            loadedObject.load(inputStream);
            loadedObject.string1.print();
            loadedObject.string2.print();

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    // Это пиздец!!!!!!!!!!!!!

    public static class Object {
        public String string1;
        public String string2;

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.print(countStrings-2 + ",");
            printWriter.print(string1.number + ",");
            printWriter.print(string2.number + ",");
            printWriter.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            Scanner scanner = new Scanner(inputStream).useDelimiter(",");
            int temp = countStrings;
            countStrings = scanner.nextInt();
            string1 = new String();
            string2 = new String();
            countStrings = temp;
            scanner.close();
        }
    }

    public static int countStrings;

    public static class String {
        private final int number;

        public String() {
            number = ++countStrings;
        }

        public void print() {
            System.out.println("string #" + number);
        }
    }
}
