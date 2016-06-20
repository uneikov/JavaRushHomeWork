package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Solution
{
    public static void main(String args[])throws IOException
    {
        String inputString;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<String> myString = new LinkedList<>();

        System.out.println("Введите имя файла для записи: ");
        String fileName = reader.readLine();
        // нужно ли писать в файл "exit"?

        System.out.println("Введите несколько строк: ");

        try{
            for(;;){
                inputString = reader.readLine();
                if (inputString.equals("exit")) {myString.add(inputString); break;}
                else myString.add(inputString);
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }

        try{
            FileWriter writer = new FileWriter(fileName, false);
            for (String s : myString) writer.write(s+"\r\n");
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }

        finally {
            reader.close();
        }
    }
}
