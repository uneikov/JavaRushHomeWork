package com.javarush.test.level22.lesson13.task01;

import java.util.ArrayList;
import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {

    public static String [] getTokens(String query, String delimiter) {
        if (query == null) return null; // проверка на нуль

        ArrayList<String> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(query, delimiter);

        while (st.hasMoreElements())list.add(st.nextToken());

        String[] result = new String[list.size()];
        return list.toArray(result);
    }
}