package com.javarush.test.level17.lesson10.bonus01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
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

        if (args.length < 2 || args.length > 6 || args.length == 3) { System.out.println("Input error!"); System.exit(0); }
        if (args.length == 2){
            if (args[0].equals("-d")) delete(Integer.parseInt(args[1]));
            else if(args[0].equals("-i")) info(Integer.parseInt(args[1]));
            else { System.out.println("Input error!"); System.exit(0); }
        }
        else if(args[0].equals("-c")) {
            if(args.length == 4) {
                if (args[2].equals("м")) sex = Sex.MALE;
                else sex = Sex.FEMALE;
                try{bd = inDateFormat.parse(args[3]);}catch (ParseException ex){System.out.println("Error!");}
                create(args[1], sex, bd);
            }
            else if(args.length == 5) {
                if (args[3].equals("м")) sex = Sex.MALE;
                else sex = Sex.FEMALE;
                try{bd = inDateFormat.parse(args[4]);}catch (ParseException ex){System.out.println("Error!");}
                create(args[1] + " " + args[2], sex, bd);
            }
            else {System.out.println("Input error!"); System.exit(0); }
        }
        else if(args[0].equals("-u")){
            if(args.length == 5) {
                id = Integer.parseInt(args[1]);
                if (args[3].equals("м")) sex = Sex.MALE;
                else sex = Sex.FEMALE;
                try{bd = inDateFormat.parse(args[4]);}catch (ParseException ex){System.out.println("Error!");}
                update(id, args[2], sex, bd);
            }
            else  if(args.length == 6) {
                id = Integer.parseInt(args[1]);
                if (args[4].equals("м")) sex = Sex.MALE;
                else sex = Sex.FEMALE;
                try{bd = inDateFormat.parse(args[5]);}catch (ParseException ex){System.out.println("Error!");}
                update(id, args[2] + " " + args[3], sex, bd);
            }
            else { System.out.println("Input error!"); System.exit(0); }
        }else { System.out.println("Input error!"); System.exit(0); }
    }

    public static void create(String name, Sex sex, Date birthday){
        if (sex == Sex.MALE)
            allPeople.add(Person.createMale(name, birthday));
        else
            allPeople.add(Person.createFemale(name, birthday));
        System.out.println(allPeople.size()-1);
    }
    public static void update(int id, String name, Sex sex, Date birthday){
        Person currentPersona = allPeople.get(id);
        currentPersona.setName(name);
        if (sex == Sex.MALE)
            currentPersona.setSex(Sex.MALE);
        else
            currentPersona.setSex(Sex.FEMALE);
        currentPersona.setBirthDay(birthday);
    }
    public static void delete(int id){
        allPeople.get(id).setName(null);
        allPeople.get(id).setSex(null);
        allPeople.get(id).setBirthDay(null);
    }
    public static void info(int id){
        SimpleDateFormat outDateFormat = new SimpleDateFormat("dd-MMM-yyy", Locale.ENGLISH);
        String name = allPeople.get(id).getName();
        String sex = (allPeople.get(id).getSex() == Sex.MALE) ? "м" : "ж";
        Date bd = allPeople.get(id).getBirthDay();
        System.out.println(name + " " + sex + " " + outDateFormat.format(bd));
    }
}
