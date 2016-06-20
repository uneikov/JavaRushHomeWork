package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        String s2 = reader.readLine();
        String s3 = reader.readLine();
        String s4 = reader.readLine();
        int a = Integer.parseInt(s1);
        int b = Integer.parseInt(s2);
        int c = Integer.parseInt(s3);
        int d = Integer.parseInt(s4);
        if(a>b)
        {
            if (c>d)
            {
                if (a>c) System.out.println(a);
                else System.out.println(c);
            } else
            {
                if (a>d) System.out.println(a);
                else System.out.println(d);
            }
        }
        else {
            if (c>d)
            {
                if (b>c) System.out.println(b);
                else System.out.println(c);
            } else
            {
                if (b>d) System.out.println(b);
                else System.out.println(d);
            }
        }
    }
}
