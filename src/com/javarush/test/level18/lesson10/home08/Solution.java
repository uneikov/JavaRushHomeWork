package com.javarush.test.level18.lesson10.home08;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {

    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();
    public static int[] codeTable = new int[255];
    static {
        for (int i = 0; i < 255; i++) codeTable[i] = i;
    }

    public static void main(String[] args) {

        String fileName;
        Scanner scan = new Scanner(System.in);

        while (true){
            fileName = scan.nextLine();
            if ("".equals(fileName) || "exit".equals(fileName)) break;
            new ReadThread(fileName).start();
        }

        scan.close();
    }

    public static class ReadThread extends Thread {
        private String filename;
        private int maxByte;
        public ReadThread(String fileName) {
            this.filename = fileName;
        }
        public void run(){
            try
            {
                maxByte = findMaxByte(filename);
                resultMap.put(filename, maxByte);

            }catch (IOException ex) {}

        }
        public int findMaxByte(String filename)throws IOException{

            int inByte;
            int maxByte = 0;
            int maxCount = 0;
            int[] countTable = new int[255];

            FileInputStream in = new FileInputStream(filename);
            while (in.available() > 0) {
                inByte = in.read();
                for (int i = 0; i < 255; i++) {
                    if (inByte == codeTable[i]) countTable[i]++;
                }
            }
            for (int i= 0; i < 255 ; i++) {
                if (countTable[i] > maxCount){
                    maxCount = countTable[i];
                    maxByte = codeTable[i];
                }
            }
            in.close();
            return maxByte;
        }
    }
}
