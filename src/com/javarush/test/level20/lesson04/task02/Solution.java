package com.javarush.test.level20.lesson04.task02;

import java.io.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/* Как сериализовать JavaRush?
Сделайте так, чтобы сериализация класса JavaRush была возможной
*/
public class Solution {

    public static class JavaRush implements Serializable{
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            ObjectOutputStream objStream = new ObjectOutputStream(outputStream);
            if (users.size() != 0) objStream.writeObject(this);
            objStream.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            ObjectInputStream objStream = new ObjectInputStream(inputStream);
            JavaRush jr = (JavaRush) objStream.readObject();
            this.users = jr.users;
        }
    }
}
