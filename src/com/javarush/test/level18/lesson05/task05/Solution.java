package com.javarush.test.level18.lesson05.task05;

/* DownloadException
1 Считывать с консоли имена файлов.
2 Если файл меньше 1000 байт, то:
2.1 Закрыть потоки
2.2 выбросить исключение DownloadException
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws DownloadException
    {
        try
        {
            Scanner sc = new Scanner(new InputStreamReader(System.in));
            for (;;)
            {
                String inFileName = sc.nextLine();
                FileInputStream in = new FileInputStream(inFileName);
                int fileSize = in.available();
                if (fileSize < 1000)
                {
                    sc.close();
                    in.close();
                    throw new DownloadException();
                }
            }
        }
        catch (IOException ex) {}
    }

    public static class DownloadException extends Exception
    {

    }
}
