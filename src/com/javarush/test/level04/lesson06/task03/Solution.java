package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
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
        int a = Integer.parseInt(s1);
        int b = Integer.parseInt(s2);
        int c = Integer.parseInt(s3);
        if (a < b )
        {
            if (b < c) System.out.println(c + "\n" + b + "\n" + a + "\n");
        }
        if (a < c )
        {
            if (c < b) System.out.println(b + "\n" + c + "\n" + a + "\n");
        }
        if (b < a )
        {
            if (a < c) System.out.println(c + "\n" + a + "\n" + b + "\n");
        }
        if (b < c )
        {
            if (c < a) System.out.println(a + "\n" + c + "\n" + b + "\n");
        }
        if (c < a )
        {
            if (a < b) System.out.println(b + "\n" + a + "\n" + c + "\n");
        }
        if (c < b )
        {
            if (b < a) System.out.println(a + "\n" + b + "\n" + c + "\n");
        }
    }
}
