package com.javarush.test.level18.lesson10.home08;

/**
 * Created by URAN on 08.04.2016.
 */
class QuickSortForByteArray {

    static void qsort(byte items[]) {
        qs(items,0,items.length-1);
    }

    private static void qs(byte items[], int left, int right) {
        int i, j;
        byte x,temp;
        i = left; j = right;
        x = items[(left+right)/2];
        do {
            while((items[i] < x) && (i < right)) i++;
            while ((x < items[j] && (j > left))) j--;
            if (i <= j) {
                temp = items[i];
                items[i] = items[j];
                items[j] = temp;
                i++; j--;
            }
        } while (i <= j);
        if (left < j) qs(items, left, j);
        if (i < right) qs(items, i, right);
    }

}