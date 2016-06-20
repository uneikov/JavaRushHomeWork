package com.javarush.test.level20.lesson04.task05;

import java.io.*;

/* Как сериализовать что-то свое?
Сделайте так, чтобы сериализация класса Object была возможной
*/
public class Solution {

    public static class Object implements Serializable{
        public String string1;
        public String string2;

        public void save(OutputStream outputStream) throws Exception {
            ObjectOutputStream ois = new ObjectOutputStream(outputStream);
            ois.writeObject(this);
        }

        public void load(InputStream inputStream) throws Exception {
            ObjectInputStream ois = new ObjectInputStream(inputStream);
            Object o = (Object) ois.readObject();
            this.string1 = o.string1;
            this.string2 = o.string2;
        }
    }

    public static int countStrings; // не требуется сериализовать/десериализовать отдельно?!

    public static class String implements Serializable{
        private final int number;

        public String() {
            number = ++countStrings;
        }

        public void print() {
            System.out.println("string #" + number);
        }
    }
}
