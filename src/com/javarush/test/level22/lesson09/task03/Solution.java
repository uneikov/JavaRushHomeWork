package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
    public static void main(String[] args) {
        Set<String> cities = new TreeSet<>();
        String[] words;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader lineReader = new BufferedReader(new FileReader(br.readLine())))
        {
            cities.addAll(Arrays.asList(lineReader.readLine().split(" ")));
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

        words = cities.toArray(new String[cities.size()]);
        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {

        if (words == null || words.length == 0)
            return new StringBuilder();
        if ("".equals(words[0]) || words.length == 1)
            return new StringBuilder(words[0]);

        StringBuilder result;
        result = findLongestChain(words);

        return result;
    }

    public static StringBuilder findLongestChain(String[] words){
        int MAX = 0;
        int count = 0;
        int sbLength = 0;
        StringBuilder temp = new StringBuilder();
        StringBuilder result = new StringBuilder();
        LinkedList<String> chain;

        while (count < words.length*10 || sbLength == words.length){
            chain = new LinkedList<>(Arrays.asList(words));
            Collections.shuffle(chain);
            temp.append(chain.get(0));
            chain.remove(0);
            temp =findChain(temp,chain);
            sbLength = temp.toString().split(" ").length;
            if (sbLength > MAX){
                MAX = sbLength;
                result = new StringBuilder(temp);
            }
            if (sbLength == MAX) count++;
            temp.delete(0, temp.length());
        }
        return result;
    }

    public static StringBuilder findChain(StringBuilder accumulator, LinkedList<String> chain){

        for (int index = 0; index < chain.size(); index++){
            char end = accumulator.toString().toLowerCase().charAt(accumulator.length()-1);
            char begin = chain.get(index).toLowerCase().charAt(0);
            if (begin == end){
                accumulator.append(" ").append(chain.get(index));
                chain.remove(index);
                findChain(accumulator, chain);
            }
        }
        return accumulator;
    }
}
