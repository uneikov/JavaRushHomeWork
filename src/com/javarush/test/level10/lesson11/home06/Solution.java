package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Human firstMan = new Human("adam");
        System.out.println(firstMan);
    }

    public enum Gender {
        MALE, FEMALE
    }


    public static class Human
    {
        private String nickname;
        private String firstName;
        private String lastName;
        private String adress;
        private int age;
        private Gender gender;


        public  Human(String nickname) { // 1
            this.nickname = nickname;
        }

        public  Human(String firstName, String lastName) { // 2
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public  Human(String firstName, String lastName, String nickname) { // 3
            this.firstName = firstName;
            this.lastName = lastName;
            this.nickname = nickname;
        }

        public  Human(String firstName, String lastName, String nickname, int age) { // 4
            this.firstName = firstName;
            this.lastName = lastName;
            this.nickname = nickname;
            this.age = age;
        }

        public  Human(String firstName, String lastName, String nickname, int age, Gender gender) { // 5
            this.firstName = firstName;
            this.lastName = lastName;
            this.nickname = nickname;
            this.age = age;
            this.gender = gender;
        }

        public  Human(String nickname, Gender gender) { // 6
            this.nickname = nickname;
            this.gender = gender;
        }

        public  Human(String nickname, String adress, Gender gender) { // 7
            this.nickname = nickname;
            this.adress = adress;
            this.gender = gender;
        }

        public  Human(String nickname, int age, Gender gender) { // 8
            this.nickname = nickname;
            this.age = age;
            this.gender = gender;
        }

        public  Human(String nickname, int age) { // 9
            this.nickname = nickname;
            this.age = age;
        }

        public  Human(String firstName, String lastName, String nickname,String adress, int age, Gender gender) { // 10
            this.firstName = firstName;
            this.lastName = lastName;
            this.nickname = nickname;
            this.adress = adress;
            this.age = age;
            this.gender = gender;
        }

    }
}
