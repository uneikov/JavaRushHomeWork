package com.javarush.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        int id;
        Sex sex = null;
        Date bd = new Date();
        SimpleDateFormat inDateFormat = new SimpleDateFormat("dd/MM/yyy", Locale.ENGLISH);

        if (args[0].equals("-d")){
            for (int i = 0; i < args.length - 1; i++)  delete(Integer.parseInt(args[i + 1]));
        }
        else
            if(args[0].equals("-i")) {
                for (int i = 0; i < args.length - 1; i++) info(Integer.parseInt(args[i + 1]));
            }
            else
                if(args[0].equals("-c")) {
                    for(int i = 0; i < args.length -1; i+=3) {
                        if (args[i + 2].equals("м")) sex = Sex.MALE;
                        else sex = Sex.FEMALE;
                        try{bd = inDateFormat.parse(args[i + 3]);}catch (ParseException ex){System.out.println("Error!");}
                        create(args[i + 1], sex, bd);
                    }
                }
                else
                    if(args[0].equals("-u")){
                        for(int i = 0; i < args.length -1; i+=4) {
                            id = Integer.parseInt(args[i + 1]);
                            if (args[i + 3].equals("м")) sex = Sex.MALE;
                            else sex = Sex.FEMALE;
                            try{bd = inDateFormat.parse(args[i + 4]);}catch (ParseException ex){System.out.println("Error!");}
                            update(id, args[i + 2], sex, bd);
                        }
                    }
                    else { System.out.println("Input error!"); System.exit(0); }

    }

    public synchronized static void create(String name, Sex sex, Date birthday){
        if (sex == Sex.MALE)
            allPeople.add(Person.createMale(name, birthday));
        else
            allPeople.add(Person.createFemale(name, birthday));
        System.out.println(allPeople.size()-1);
    }
    public synchronized static void update(int id, String name, Sex sex, Date birthday){
        Person currentPersona = allPeople.get(id);
        currentPersona.setName(name);
        if (sex == Sex.MALE)
            currentPersona.setSex(Sex.MALE);
        else
            currentPersona.setSex(Sex.FEMALE);
        currentPersona.setBirthDay(birthday);
    }
    public synchronized static void delete(int id){
        allPeople.get(id).setName(null);
        allPeople.get(id).setSex(null);
        allPeople.get(id).setBirthDay(null);
    }
    public synchronized static void info(int id){
        SimpleDateFormat outDateFormat = new SimpleDateFormat("dd-MMM-yyy", Locale.ENGLISH);
        String name = allPeople.get(id).getName();
        String sex = (allPeople.get(id).getSex() == Sex.MALE) ? "м" : "ж";
        Date bd = allPeople.get(id).getBirthDay();
        System.out.println(name + " " + sex + " " + outDateFormat.format(bd));
    }
}
