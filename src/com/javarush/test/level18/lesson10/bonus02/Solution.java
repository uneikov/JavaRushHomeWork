package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/


import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public static void main(String[] args)
    {
        if (args.length < 4 || !args[0].equals("-c")) {
            System.out.println("Invalid parameters");
            System.exit(0);
        }

        byte[] fieldToCreate = new byte[0];
        BufferedReader infile;
        String name = "";

        String[] parsedArgs = parseArgs(args);
        String productName = parsedArgs[1];
        String price = parsedArgs[2];
        String quantity = parsedArgs[3];

        Scanner scan = new Scanner(System.in);
        try {
            name = scan.nextLine();
            infile = new BufferedReader(new FileReader(name));
            fieldToCreate = createNewRow(infile, productName, price, quantity) ;
            FileOutputStream outfile = new FileOutputStream(name, true);
            outfile.write(fieldToCreate);
            scan.close();
            infile.close();
            outfile.close();
        }catch (IOException ex){}
    }

    public static String[] parseArgs(String[] args){
        int endCount = 1;
        String prodname = "";
        String[] newArgs = new String[4];
        Pattern pattern = Pattern.compile("[0-9.]");
        for (int i = 1; i < args.length; i++){
            Matcher matcher = pattern.matcher(args[i]);
            if (matcher.find()) endCount = i-1;
        }

        prodname = args[1];
        for (int i = 2; i < endCount; i ++) prodname = prodname + " " + args[i];
        newArgs[1] = prodname;
        newArgs[2] = args[endCount];
        newArgs[3] = args[endCount+1];
        return newArgs;
    }
    public static byte[] createNewRow(BufferedReader file, String prodname, String price, String quantity) throws IOException
    {
        byte[] fieldToCreate;
        String newId;
        newId = "" + (Integer.parseInt(findMaxId(file)) + 1);
        while (newId.length() < 8) newId = newId + " ";
        if (prodname.length() > 30){
            prodname = prodname.substring(0, 30);
        }else {
            while (prodname.length() < 30) prodname = prodname + " ";
        }
        while (price.length() < 8) price = price + " ";
        while (quantity.length() < 4) quantity = quantity + " ";
        String result = newId + prodname + price + quantity + "\r\n";
        fieldToCreate = result.getBytes();

        return fieldToCreate;
    }
    public static String findMaxId(BufferedReader file)throws IOException{
        String id = "";
        String tmpId;

        while ((tmpId = file.readLine())!= null) {
            id = tmpId .substring(0, 8).trim();
        }

        return id;
    }
}
