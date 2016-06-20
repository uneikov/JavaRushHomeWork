package com.javarush.test.level14.lesson08.home03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/* User, Looser, Coder and Proger
1. Ввести [в цикле] с клавиатуры несколько строк (ключей).
Строки(ключи) могут быть такими: "user", "looser", "coder", "proger".
Ввод окончен, когда строка не совпадает ни с одной из выше указанных.

2. Для каждой введенной строки нужно:
2.1. Создать соответствующий объект [см Person.java], например, для строки "user" нужно создать объект класса User.
2.2. Передать этот объект в метод doWork.

3. Написать реализацию метода doWork, который:
3.1. Вызывает метод live() у переданного обекта, если этот объект (person) имеет тип User.
3.2. Вызывает метод doNothing(), если person имеет тип Looser.
3.3. Вызывает метод coding(), если person имеет тип Coder.
3.4. Вызывает метод enjoy(), если person имеет тип Proger.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        List<String> keyList = new LinkedList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;
        //-------------------------------------------
        try {
            for (;;) {
                key = reader.readLine();
                if (key.equals("user") || key.equals("looser") || key.equals("coder") || key.equals("proger")) {
                    keyList.add(key);
                } else {
                    break;
                }
            }
        } catch (Exception ex){}
        //--------------------------------------------
        for (String k : keyList) {

            switch (k){
                case "user" : {Person.User user = new Person.User(); doWork(user); break;}
                case "coder" : {Person.Coder coder = new Person.Coder(); doWork(coder); break;}
                case "proger" : {Person.Proger proger = new Person.Proger(); doWork(proger); break;}
                case "looser" : {Person.Looser looser = new Person.Looser(); doWork(looser);break;}
            }
        }
    }

    public static void doWork(Person person)
    {
        if (person instanceof Person.User) Person.User.live();
        else if (person instanceof Person.Proger) Person.Proger.enjoy();
        else if (person instanceof Person.Coder) Person.Coder.coding();
        else if (person instanceof Person.Looser) Person.Looser.doNothing();
    }
}
