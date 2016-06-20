package com.javarush.test.level04.lesson04.task06;

/* День недели
Ввести с клавиатуры номер дня недели, в зависимости от номера вывести название «понедельник», «вторник», «среда», «четверг», «пятница», «суббота», «воскресенье»,
если введен номер больше или меньше 7 – вывести «такого дня недели не существует».
Пример для номера 5:
пятница
Пример для номера 10:
такого дня недели не существует
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       String s = reader.readLine();
       int n = Integer.parseInt(s);
       if (n<1) System.out.println("такого дня недели не существует");
        else { if (n>7) System.out.println("такого дня недели не существует");
           else {
           if (n == 1) System.out.println("понедельник");
           if (n == 2) System.out.println("вторник");
           if (n == 3) System.out.println("среда");
           if (n == 4) System.out.println("четверг");
           if (n == 5) System.out.println("пятница");
           if (n == 6) System.out.println("суббота");
           if (n == 7) System.out.println("воскресенье");
           }
       }

    }
}