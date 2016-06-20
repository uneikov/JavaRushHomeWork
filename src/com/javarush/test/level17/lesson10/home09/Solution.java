package com.javarush.test.level17.lesson10.home09;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws FileNotFoundException {
        String filePathOne = "";
        String filePathTwo = "";

        try {
            //BufferedReader nameReader = new BufferedReader(new InputStreamReader(System.in));
            //filePathOne = nameReader.readLine();
            //filePathTwo = nameReader.readLine();
            //nameReader.close();
            filePathOne = "C:\\Users\\URAN\\Desktop\\test.txt";
            filePathTwo = "C:\\Users\\URAN\\Desktop\\test1.txt";

            BufferedReader fileReader1 =new BufferedReader(new InputStreamReader(new FileInputStream(filePathOne)));
            String line;
            while ((line = fileReader1.readLine()) != null){
                allLines.add(line);
            }
            fileReader1.close();

            BufferedReader fileReader2 =new BufferedReader(new InputStreamReader(new FileInputStream(filePathTwo)));
            while ((line = fileReader2.readLine()) != null){
                forRemoveLines.add(line);
            }
            fileReader2.close();

            new Solution().joinData(); // обратите внимание на вызов метода

        }catch (Exception ex){}
        if (allLines != null) for (String s : allLines) System.out.println(s);

    }
    // синхронизированный метод
    public  synchronized void joinData () throws CorruptedDataException {
        if(allLines.containsAll(forRemoveLines)){
            allLines.removeAll(forRemoveLines);
            return;
        }
        for (String s : forRemoveLines) {
            if (!allLines.contains(s)){
                allLines.clear();
                throw  new CorruptedDataException();
            }
        }
    }
}
