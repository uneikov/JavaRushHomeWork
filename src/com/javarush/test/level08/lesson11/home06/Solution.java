package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<Human> grandpa1Childs = new ArrayList<>();
        ArrayList<Human> grandma1Childs = new ArrayList<>();
        ArrayList<Human> grandpa2Childs = new ArrayList<>();
        ArrayList<Human> grandma2Childs = new ArrayList<>();
        ArrayList<Human> fatherChilds = new ArrayList<>();
        ArrayList<Human> motherChilds = new ArrayList<>();
        ArrayList<Human> childChilds = new ArrayList<>(0); // у детей нет детей


        Human grandpa1 = new Human("John", true, 65, grandpa1Childs); // дедушки, бабушки
        Human grandma1 = new Human("Sally", false, 60, grandma1Childs);
        Human grandpa2 = new Human("Jerry", true, 68, grandpa2Childs);
        Human grandma2 = new Human("Pearl", false, 66, grandma2Childs);

        Human father = new Human("Bill", true, 48, fatherChilds); // папа, мама
        Human mother = new Human("Molly", false, 43, motherChilds);

        Human son1 = new Human("Roger", true, 18, childChilds); // дети
        Human son2 = new Human("Troy", true, 15, childChilds);
        Human daughter1 = new Human("Sara", false, 13, childChilds);


        grandpa1Childs.add(father);
        grandma1Childs.add(father);
        grandpa2Childs.add(mother);
        grandma2Childs.add(mother);
        fatherChilds.add(son1);
        fatherChilds.add(son2);
        fatherChilds.add(daughter1);
        motherChilds.add(son1);
        motherChilds.add(son2);
        motherChilds.add(daughter1);


        System.out.println(grandpa1);
        System.out.println(grandma1);
        System.out.println(grandpa2);
        System.out.println(grandma2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(son1);
        System.out.println(son2);
        System.out.println(daughter1);
    }

    public static class Human
    {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;

        Human(String name, boolean sex, int age, ArrayList<Human> children )
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;
            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }
            return text;
        }
    }

}
