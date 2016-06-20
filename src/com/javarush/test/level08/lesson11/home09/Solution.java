package com.javarush.test.level08.lesson11.home09;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static java.sql.Date.valueOf;


/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args)
    {
        String date = "FEBRUARY 23 2016";
        System.out.println(date + " = " + isDateOdd(date));
    }

    public static boolean isDateOdd(String date)
    {
        String[] sIn = date.trim().split(" ");
        int year = Integer.parseInt(sIn[2]);
        int day = Integer.parseInt(sIn[1]);
        int month = 0;
        switch (sIn[0])
        {
           case "JANUARY" : month = Calendar.JANUARY; break;
           case "FEBRUARY" : month = Calendar.FEBRUARY; break;
           case "MARCH" : month = Calendar.MARCH; break;
           case "APRIL" : month = Calendar.APRIL; break;
           case "MAY" : month = Calendar.MAY; break;
           case "JUNE" : month = Calendar.JUNE; break;
           case "JULY" : month = Calendar.JULY; break;
           case "AUGUST" : month = Calendar.AUGUST; break;
           case "SEPTEMBER" : month = Calendar.SEPTEMBER; break;
           case "NOVEMBER" : month = Calendar.NOVEMBER; break;
           case "OCTOBER" : month = Calendar.OCTOBER; break;
           case "DECEMBER" : month = Calendar.DECEMBER;
        }

        Calendar ddate = new GregorianCalendar();
        ddate.set(year, month, day);
        if (ddate.get(Calendar.DAY_OF_YEAR)%2 !=0)
            return true;
        else
            return false;
    }
}
