package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution
{
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException
    {
        if (args.length != 1) {System.out.println("Invalid args"); System.exit(-1);}

        String line;
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));

        while ((line = reader.readLine()) != null)
        {
            PEOPLE.add(new Person(getName(line), getDate(line).getTime()));
        }
        for (Person p : PEOPLE) System.out.println(p.getName() + " " + p.getBirthday());
        reader.close();
    }

    public static String getName(String line)
    {
        String personName = "";
        String[] sline = line.split(" ");
        personName = sline[0];
        for ( int i = 1; i < sline.length-3; i++) personName += " "+ sline[i];
        return personName;
    }

    public static GregorianCalendar getDate(String line)
    {
        GregorianCalendar birthday;
        String[] sline = line.split(" ");
        int day = Integer.parseInt(sline[sline.length-3]);
        int month = Integer.parseInt(sline[sline.length-2]) - 1;
        int year = Integer.parseInt(sline[sline.length-1]);
        birthday = new GregorianCalendar(year, month, day);
        return birthday;
    }
}
