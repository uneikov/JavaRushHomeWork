package com.javarush.test.level04.lesson13.task02;

import java.io.*;

/* Рисуем прямоугольник
Ввести с клавиатуры два числа m и n.
Используя цикл for вывести на экран прямоугольник размером m на n из восьмёрок.
Пример: m=2, n=4
8888
8888
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        String s2 = reader.readLine();
        int m = Integer.parseInt(s1);
        int n = Integer.parseInt(s2);
        int i = 1;
        for (;i <= m; i++)
        {
            int j = 1;
            for (;j <= n; j++)
            {
                System.out.print("8");
            }
            System.out.println();
        }
    }
}
