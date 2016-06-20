package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<Human> family = new ArrayList<>();
        Human Grandfather1 = new Human("Виктор", true, 65, null, null); family.add(Grandfather1);
        Human Grandfather2 = new Human("Кирилл", true, 63, null, null); family.add(Grandfather2);
        Human Grandmother1 = new Human("Клавдия", false, 60, null, null); family.add(Grandmother1);
        Human Grandmother2 = new Human("Дарья", false, 58, null, null); family.add(Grandmother2);
        Human father = new Human("Вячеслав", true, 48, Grandfather1, Grandmother1); family.add(father);
        Human mother = new Human("Тамара", false, 45, Grandfather2, Grandmother2); family.add(mother);
        Human son1 = new Human("Петр", true, 15, father, mother); family.add(son1);
        Human son2 = new Human("Тимофей", true, 13, father, mother); family.add(son2);
        Human daughter1 = new Human("Вероника", false, 10, father, mother); family.add(daughter1);
        for (Human h : family) System.out.println(h);
    }

    public static class Human
    {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        Human(String name, boolean sex, int age, Human father, Human mother)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        @Override
        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
