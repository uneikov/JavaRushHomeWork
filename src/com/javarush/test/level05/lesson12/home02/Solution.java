package com.javarush.test.level05.lesson12.home02;

/* Man and Woman
1. Внутри класса Solution создай public static классы Man и Woman.
2. У классов должны быть поля: name(String), age(int), address(String).
3. Создай конструкторы, в которые передаются все возможные параметры.
4. Создай по два объекта каждого класса со всеми данными используя конструктор.
5. Объекты выведи на экран в таком формате [name + " " + age + " " + address].
*/

public class Solution
{
    public static void main(String[] args)
    {
        Man man1 = new Man("Adam", 33, "Paradise UnderTheTree, 1a");
        Man man2 = new Man("Devil", 55, "Terra ave 12-12");
        Woman woman1 = new Woman("Eva", 17, "Paradise UnderTheTree, 1b");
        Woman woman2 = new Woman("Death", 999, "Vyazov str. 147-13");
        System.out.println(man1.name + " " + man1.age + " " + man1.address);
        System.out.println(man2.name + " " + man2.age + " " + man2.address);
        System.out.println(woman1.name + " " + woman1.age + " " + woman1.address);
        System.out.println(woman2.name + " " + woman2.age + " " + woman2.address);
    }

   public static class Man
   {
       String name;
       int age;
       String address;

       public Man(String name, int age, String adress)
       {
           this.name = name;
           this. age = age;
           this.address = adress;
       }
   }

    public static class Woman
    {
        String name;
        int age;
        String address;

        public Woman(String name, int age, String adress)
        {
            this.name = name;
            this. age = age;
            this.address = adress;
        }
    }
}
