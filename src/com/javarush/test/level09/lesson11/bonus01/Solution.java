package com.javarush.test.level09.lesson11.bonus01;

import java.io.*;

/* Нужно исправить программу, чтобы компилировалась и работала
Задача: Программа вводит два имени файла. И копирует первый файл на место заданное вторым именем.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;


        do
        {
            try
            {
                String sourceFileName = reader.readLine();
                fileInputStream = new FileInputStream(sourceFileName);
            }
            catch (IOException e)
            {
                System.out.println("Файл не существует.");
            }
        }while (fileInputStream == null);

        do
        {
            try
            {
                String destinationFileName = reader.readLine();
                fileOutputStream = new FileOutputStream(destinationFileName);
            }
            catch (IOException e)
            {
                System.out.println("Файл не существует.");
            }
        }while (fileOutputStream == null);


        int count = 0;
        while (fileInputStream.available() > 0)
        {
            int data = fileInputStream.read();
            fileOutputStream.write(data);
            count++;
        }

        System.out.println("Скопировано байт " + count);

        fileInputStream.close();
        fileOutputStream.close();
    }
}
