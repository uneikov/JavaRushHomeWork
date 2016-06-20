package com.javarush.test.level22.lesson09.task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) {

        ArrayList<String> strings = new ArrayList<>();
        ArrayList<String> reversed = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        Pair palindrome;
        String[] nextLine;
        String next, original, search;

        try(  BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
              BufferedReader reader = new BufferedReader(new FileReader(console.readLine()))  )
        {
            while ((next = reader.readLine()) != null) {
                nextLine= next.split(" +"); // исключаем слова-пробелы?
                for (int i = 0; i < nextLine.length; i++) strings.add(nextLine[i]);
            }
            reader.close();
        }catch (IOException ex){ex.printStackTrace();}

        for (int i = 0; i < strings.size(); i++) {
            reversed.add(stringBuilder.append(strings.get(i)).reverse().toString());
            stringBuilder.delete(0, stringBuilder.length());
        }

        for ( int i = 0; i < strings.size(); i++){
            original = strings.get(i);
            search = reversed.get(i);
            for (int j = i+1; j < strings.size(); j++)
            {
                if (strings.get(j).equals(search))
                {
                    palindrome = new Pair();
                    palindrome.first = original;
                    palindrome.second = search;
                    if (!result.contains(palindrome)) result.add(palindrome); // кот-ток и ток-кот проходят
                    break;
                }
            }
        }

        for (int i = 0; i < result.size(); i ++) System.out.println(result.get(i));
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }

        @Override
        public boolean equals(Object o)
        {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode()
        {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }
    }
}
