package com.javarush.test.level04.lesson13.task04;

import java.io.*;

/* Рисуем линии
Используя цикл for вывести на экран:
- горизонтальную линию из 10 восьмёрок
- вертикальную линию из 10 восьмёрок.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int j = 1;
        for (;j <= 10; j++)
        {
            System.out.print("8");
        }
        System.out.println();
        int i = 1;
        for (;i <=10; i++)
        {
            System.out.println("8");
        }

    }
}
