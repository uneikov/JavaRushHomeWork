package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {System.out.println("Invalid args"); System.exit(-1);}

        Map<String, Double> grossbuh = new LinkedHashMap<>();
        ArrayList<String> keyList;
        String line, name;
        Double value, oldValue;

        BufferedReader in = new BufferedReader(new FileReader(new File(args[0])));

        while ((line = in.readLine()) != null){
            name = line.split(" ")[0];
            value = Double.parseDouble(line.split(" ")[1]);
            if (grossbuh.containsKey(name)){
                oldValue = grossbuh.get(name);
                grossbuh.put(name, oldValue + value);
            }else{
                grossbuh.put(name, value);
            }
        }

        keyList = new ArrayList<>(grossbuh.size());
        for (String v : grossbuh.keySet()) keyList.add(v);
        Collections.sort(keyList);

        for (String empName : keyList)
        {
            value = grossbuh.get(empName);
            System.out.println(empName + " " + value);
        }

        in.close();
    }
}
