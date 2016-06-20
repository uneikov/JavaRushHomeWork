package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        try
        {
            Scanner sc = new Scanner(System.in);
            int one = sc.nextInt();
            int two = sc.nextInt();
            System.out.println(nodForTwo(one, two));
        }
        catch (Exception ex) {}

    }

    public static int nodForTwo(int a, int b) {
        int nod = 0;
        ArrayList<Integer> arrDiv1 = new ArrayList<>();
        ArrayList<Integer> arrDiv2 = new ArrayList<>();
        ArrayList<Integer> eqDiv1 = new ArrayList<>();

        for (int i = 1; i < a; i++) {
            if (a%i == 0) arrDiv1.add(i);
        }

        for (int i = 1; i < b; i++) {
            if (b%i == 0) arrDiv2.add(i);
        }

        for (int i = 0; i < arrDiv1.size(); i++) {
            for (int j =0; j < arrDiv2.size(); j++){
            if (arrDiv1.get(i) ==  arrDiv2.get(j)) eqDiv1.add(arrDiv1.get(i));
        }}

        if (eqDiv1.size() == 0) {
            System.out.println("Нет НОД");
        } else {
        for (int i = 0; i < eqDiv1.size(); i++) {
            if (eqDiv1.get(i) >  nod) nod = eqDiv1.get(i);
        }}
        return nod;
    }
}
