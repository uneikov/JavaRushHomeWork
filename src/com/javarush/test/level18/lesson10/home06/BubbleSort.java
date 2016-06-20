package com.javarush.test.level18.lesson10.home06;

import java.util.ArrayList;

public class BubbleSort{ // сортировка byteArray по убыванию : numArray - связанный массив
    public static void bubbleSortForLinkedArrays(ArrayList<Integer> byteArray, ArrayList<Integer> numArray)
    {
        int size = byteArray.size();
        int[] num = new int[size];
        int[] byt = new int[size];
        for (int i =0; i < byteArray.size(); i++){
            num[i] = numArray.get(i);
            byt[i] = byteArray.get(i);
        }

        int j;
        boolean flag = true;
        int temp, temp1;

        while ( flag )
        {
            flag= false;
            for( j=0;  j < num.length -1;  j++ )
            {
                if ( byt[ j ] > byt[j+1] )
                {
                    temp = byt[j];
                    temp1 = num[j];
                    num[j] = num[j+1];
                    byt[j] = byt[j+1];
                    byt[j+1] = temp;
                    num[j+1] = temp1;
                    flag = true;
                }
            }
        }
        byteArray.clear(); numArray.clear();
        for (int i =0; i < size; i++){
            byteArray.add(byt[i]);
            numArray.add(num[i]);
        }
    }
}
