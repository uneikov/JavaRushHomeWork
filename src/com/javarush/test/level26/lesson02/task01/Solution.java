package com.javarush.test.level26.lesson02.task01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution {

    private static Integer medianValue;

    public static Integer[] sort(Integer[] array) {

        Comparator<Integer> compareToMedianValue = new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                int delta = Math.abs(medianValue - o1) - Math.abs(medianValue - o2);
                if (delta == 0)
                     return o1 - o2;
                else return  delta;
            }
        };

        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(array));
        Collections.sort(arr);

        if ( arr.size()%2 == 0 ){
            medianValue = (arr.get(arr.size()/2 - 1) + arr.get( arr.size()/2))/2 ;
        }else {
            medianValue = arr.get(arr.size()/2);
        }

        Collections.sort(arr, compareToMedianValue);
        arr.toArray(array);

        return array;
    }
}
