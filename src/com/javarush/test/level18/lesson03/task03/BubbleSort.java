package com.javarush.test.level18.lesson03.task03;

import java.util.ArrayList;

// Bubble Sort Method for Descending Order

public class BubbleSort{
    public static void bubbleSortForLinkedArrays(ArrayList<Integer> ba, ArrayList<Integer> na)
    {
        int size = ba.size();
        int[] num = new int[size];
        int[] idx = new int[size];
        for (int i =0; i < ba.size(); i++){
            num[i] = na.get(i);
            idx[i] = ba.get(i);
        }
        int j;
        boolean flag = true;
        int temp, temp1;

        while ( flag )
        {
            flag= false;
            for( j=0;  j < num.length -1;  j++ )
            {
                if ( num[ j ] < num[j+1] )
                {
                    temp = num[ j ]; temp1 = idx[j];
                    num[ j ] = num[ j+1 ];
                    idx[j] = idx[j+1];
                    num[ j+1 ] = temp; idx[j+1] = temp1;
                    flag = true;
                }
            }
        }
        ba.clear(); na.clear();
        for (int i =0; i < size; i++){
            ba.add(idx[i]);
            na.add(num[i]);
        }
    }
}