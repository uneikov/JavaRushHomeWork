package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        if (args.length != 1) {System.out.println("Invalid args"); System.exit(-1);}

        Map<String, Double> grossbuh = new LinkedHashMap<>();
        ArrayList<Double> valueList;
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

        valueList = new ArrayList<>(grossbuh.size());
        for (Double v : grossbuh.values()) valueList.add(v);
        Collections.sort(valueList);
        Double max = valueList.get(valueList.size()-1);

        for (Map.Entry<String,Double> element : grossbuh.entrySet()){
            if (element.getValue().compareTo(max) == 0 )
            System.out.println(element.getKey());
        }
        in.close();
    }
}
