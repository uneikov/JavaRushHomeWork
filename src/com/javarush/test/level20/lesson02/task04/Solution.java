package com.javarush.test.level20.lesson02.task04;

import java.io.*;
import java.util.Scanner;

/* Читаем и пишем в файл статики
Реализуйте логику записи в файл и чтения из файла для класса ClassWithStatic
Метод load должен инициализировать объект включая статические поля данными из файла
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {

        try {

            File your_file_name = File.createTempFile("test", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            ClassWithStatic classWithStatic = new ClassWithStatic();
            classWithStatic.i = 3;
            classWithStatic.j = 4;
            // save method =============
            classWithStatic.save(outputStream);
            outputStream.flush();

            ClassWithStatic loadedObject = new ClassWithStatic();
            loadedObject.staticString = "something";
            loadedObject.i = 6;
            loadedObject.j = 7;
            // load method =============
            loadedObject.load(inputStream);
            System.out.println(classWithStatic.staticString + " " + classWithStatic.i + " " + classWithStatic.j);
            System.out.println(loadedObject.staticString + " " + loadedObject.i + " " + loadedObject.j);
            //check here that classWithStatic object equals to loadedObject object

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class ClassWithStatic {
        public static String staticString = "it's test static string";
        public int i;
        public int j;

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.write(staticString + ",");
            printWriter.write(i + ",");
            printWriter.write(j + ",");
            printWriter.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            Scanner scanner = new Scanner(inputStream).useDelimiter(",");
            staticString = scanner.next();
            this.i = scanner.nextInt();
            this.j = scanner.nextInt();
        }
    }
}
