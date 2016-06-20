package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
строка0                           ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка5                           ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) {

        Deque<String> queue1 = new ArrayDeque<>();
        Deque<String> queue2 = new ArrayDeque<>();
        String str1, str2;

        Scanner scanner = new Scanner(System.in);
        String file1 = scanner.nextLine();
        String file2 = scanner.nextLine();
        scanner.close();

        try {
            BufferedReader reader1 = new BufferedReader(new InputStreamReader(new FileInputStream(file1)));
            while (reader1.ready()) queue1.add(reader1.readLine());
            reader1.close();
            BufferedReader reader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file2)));
            while (reader2.ready()) queue2.add(reader2.readLine());
            reader2.close();
        }catch (IOException ex) {}

        while (queue1.size()!=0 || queue2.size()!=0){
            str1 = queue1.poll();
            str2 = queue2.poll();
            if(str1 == null && str2 != null){
                lines.add(new LineItem(Type.ADDED, str2));
                break;
            }
            if(str1 != null && str2 == null){
                lines.add(new LineItem(Type.REMOVED, str1));
                break;
            }
            if (str1.equals(str2)){
                lines.add(new LineItem(Type.SAME, str1));
            }
            else {
                if( str2.equals(queue1.peek())){
                    lines.add(new LineItem(Type.REMOVED, str1));
                    queue2.addFirst(str2);
                }else {
                    lines.add(new LineItem(Type.ADDED, str2));
                    queue1.addFirst(str1);
                }
            }
        }

        for (LineItem line : lines) System.out.printf("%s %s%n", line.type, line.line);
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
