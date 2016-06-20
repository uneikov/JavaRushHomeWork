package com.javarush.test.level22.lesson09.task02;

import java.util.HashMap;
import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {

    public static StringBuilder getCondition(Map<String, String> params) {
        StringBuilder result = new StringBuilder();
        String[] strings = new String[params.size()];
        int count = 0;

        if (params.size() == 0) return new StringBuilder();

        for (Map.Entry<String, String> map : params.entrySet()){
            if (map.getValue() != null ) strings[count++] = map.getKey() + " = '" + map.getValue() + "'";
        }

        result.append(strings[0]);
        for (int i = 1; i < count; i++) result.append(" and ").append(strings[i]);

        return result;
    }
}
