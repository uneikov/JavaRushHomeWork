package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution
{

    public static void main(String[] args)
    {

        if ( args.length < 2 || !isNumeric(args[1]) || !"-u".equals(args[0])  && !"-d".equals(args[0]))
        {
            System.out.println("Invalid parameters");
            System.exit(0);
        }

        BufferedReader infile;
        BufferedWriter outfile;
        ArrayList<String> fileBuffer = new ArrayList<>();
        String name, line, newLine, currentId;
        String productName = "";
        String price = "";
        String quantity = "";
        int iid = -1;

        String id = args[1];
        if (args.length > 2)
        {
            String[] parsedArgs = parseArgs(args);
            productName = parsedArgs[2];
            price = parsedArgs[3];
            quantity = parsedArgs[4];
        }


        try
        {
            Scanner scan = new Scanner(System.in);
            name = scan.nextLine();
            scan.close();

            infile = new BufferedReader(new FileReader(name));
            while ((line = infile.readLine()) != null) fileBuffer.add(line);
            infile.close();

            if ("-d".equals(args[0]))
            {
                for (int i = 0; i < fileBuffer.size(); i++){
                    currentId = fileBuffer.get(i).substring(0, 8).trim();
                    if (id.equals(currentId)) {
                        iid = i;
                        break;
                    }
                }
                if (iid != -1) fileBuffer.remove(iid);
            } else
            {
                for (int i = 0; i < fileBuffer.size(); i++){
                    currentId = fileBuffer.get(i).substring(0, 8).trim();
                    if (id.equals(currentId)) {
                        iid = i;
                        break;
                    }
                }
                if (iid != -1)
                {
                    fileBuffer.remove(iid);
                    newLine = createNewRow(id, productName, price, quantity);
                    fileBuffer.add(iid, newLine);
                }
            }

            outfile = new BufferedWriter(new FileWriter(name));
            outfile.write(fileBuffer.get(0));
            for (int i = 1; i < fileBuffer.size(); i++) outfile.write(System.lineSeparator() + fileBuffer.get(i));
            outfile.close();
        }
        catch (IOException ex) {}
    }

    public static String[] parseArgs(String[] args)
    {
        String[] newArgs = new String[5];
        String s = args[2];
        for (int i = 3; i < args.length-2; i++) s += " " + args[i];
        newArgs[1] = args[1];
        newArgs[2] = s;
        newArgs[3] = args[args.length - 2];
        newArgs[4] = args[args.length - 1];

        return newArgs;
    }
    public static String createNewRow(String id, String prodname, String price, String quantity) throws IOException
    {
        String newId = id.trim();

        while (newId.length() < 8) newId = newId + " ";
        if (prodname.length() > 30) prodname = prodname.substring(0, 30);
        else while (prodname.length() < 30) prodname = prodname + " ";
        while (price.length() < 8) price = price + " ";
        while (quantity.length() < 4) quantity = quantity + " ";

        return newId + prodname + price + quantity;
    }
    public static boolean isNumeric(String str)
    {
        return str.matches("\\d+");
    }
}