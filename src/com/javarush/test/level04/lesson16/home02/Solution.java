package com.javarush.test.level04.lesson16.home02;

import java.io.*;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        String s2 = reader.readLine();
        String s3 = reader.readLine();
        int a1 = Integer.parseInt(s1);
        int a2 = Integer.parseInt(s2);
        int a3 = Integer.parseInt(s3);
        if(a1 < a2 && a2 < a3) System.out.println(a2);
        if(a1 < a3 && a3 < a2) System.out.println(a3);
        if(a2 < a1 && a1 < a3) System.out.println(a2);
        if(a2 < a3 && a3 < a1) System.out.println(a3);
        if(a3 < a1 && a1 < a2) System.out.println(a2);
        if(a3 < a2 && a2 < a1) System.out.println(a3);
    }
}
