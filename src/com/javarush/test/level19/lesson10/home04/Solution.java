package com.javarush.test.level19.lesson10.home04;

import javax.lang.model.util.SimpleTypeVisitor6;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words
Закрыть потоки. Не использовать try-with-resources

Пример: words содержит слова А, Б, В
Строки:
В Б А Д  //3 слова из words, не подходит
Д А Д    //1 слово из words, не подходит
Д А Б Д  //2 слова - подходит, выводим
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {

        String name, line;
        int count = 0;
        Scanner sc = new Scanner(System.in);
        name = sc.nextLine();
        sc.close();

        BufferedReader in = new BufferedReader(new FileReader(new File(name)));
        while ((line = in.readLine()) != null){
            String[] sline = line.split(" ");
            for (int i = 0; i < sline.length; i++)
            {
                for (int ii = 0; ii < words.size(); ii++)
                {
                    if (sline[i].equals(words.get(ii))) count++;
                    if (count > 2) break;
                }
                if (count > 2) break;
            }
            if (count == 2) System.out.println(line);
            count = 0;
        }
        in.close();
    }
}
