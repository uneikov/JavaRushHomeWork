package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException{


        if (args.length != 2) {System.out.print("Invalid parameters"); System.exit(-1);}

        String line, next, newString = "";
        Pattern symAndNums = Pattern.compile("[^ ]*\\d+[^ ]*");

        BufferedReader strReader = new BufferedReader(new FileReader(new File(args[0])));
        FileWriter strWriter = new FileWriter(new File(args[1]));

        while ((line = strReader.readLine()) != null){

            Scanner strScanner = new Scanner(line);
            while ((next = strScanner.findWithinHorizon(symAndNums, line.length())) != null) {
                newString += " " + next;
            }
            strScanner.close();
        }

        strWriter.write(newString.trim());

        strReader.close();
        strWriter.close();

    }
}
