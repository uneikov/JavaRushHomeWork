package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException{

        ArrayList<String> list = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        FileInputStream file;
        byte[] buffer;
        boolean append = false;

        while (true){
            String ins = in.nextLine();
            if (ins.equals("end")) break;
            else list.add(ins);
        }

        if (list.size() != 0)
        {
            String outFile = getOutFileName(list.get(0));
            FileOutputStream out = new FileOutputStream(outFile,append);
            Collections.sort(list);

            for (int i = 0; i < list.size(); i++){
                file = new FileInputStream(list.get(i));
                buffer = new byte[file.available()];
                file.read(buffer);
                out.write(buffer);
                file.close();
            }
            out.close();

        }else {
            System.out.println("Список пуст");
            in.close();
        }

    }
    public static String getOutFileName(String s){
        Pattern pattern = Pattern.compile(".part[0-9]+");
        Matcher match = pattern.matcher(s);
        String result = "";
        if (match.find()){
            result = s.substring(0, match.start());
        }
        return result;
    }
}
