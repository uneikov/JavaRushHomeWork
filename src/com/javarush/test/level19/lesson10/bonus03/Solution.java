package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution
{

    public static void main(String[] args)
    {

        if (args.length != 1) { System.out.print("Invalid arguments"); System.exit(-1); }

        String next, result = "";
        String open = "<" + args[0] + "|<" + args[0] + ">";

        String close = "</" + args[0] + ">";
        int clength = close.length();

        String tag = open + "|" + close;
        Pattern tagPattern = Pattern.compile(tag);

        Stack<Integer> stack = new Stack<>();
        TreeMap<Integer, Integer> brackets = new TreeMap<>();

        try
        {
            Scanner scanner = new Scanner(System.in);
            BufferedReader reader = new BufferedReader(new FileReader(scanner.nextLine()));
            while ((next = reader.readLine()) != null) result += next;
            reader.close();
            scanner.close();
        }
        catch (IOException ex) {}

        Matcher matcher = tagPattern.matcher(result);

        while (matcher.find()) {
            if ((matcher.end() - matcher.start()) < clength) stack.push(matcher.start());
             else brackets.put(stack.pop(), matcher.start());
        }

        for (Map.Entry<Integer, Integer> tree : brackets.entrySet())
        {
            System.out.println(result.substring(tree.getKey(), tree.getValue() + close.length()));
        }
    }
}
