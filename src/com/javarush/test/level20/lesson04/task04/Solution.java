package com.javarush.test.level20.lesson04.task04;

import java.io.*;
import java.util.Scanner;

/* Как сериализовать static?
Сделайте так, чтобы сериализация класса ClassWithStatic была возможной
*/
public class Solution {

    public static class ClassWithStatic implements Serializable{
        public static String staticString = "it's test static string";
        public int i;
        public int j;

        public void save(OutputStream outputStream) throws Exception {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            serializeStatic(objectOutputStream);
            objectOutputStream.writeObject(this);
        }

        public void load(InputStream inputStream) throws Exception {
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            deserializeStatic(objectInputStream);
            ClassWithStatic cws = (ClassWithStatic) objectInputStream.readObject();
            this.i = cws.i;
            this.j = cws.j;
        }
        //  два метода для работы со статическими полями
        private static void serializeStatic(ObjectOutputStream oos) throws IOException{
            oos.writeInt(staticString.length());
            oos.write(staticString.getBytes());
        }

        private static void deserializeStatic(ObjectInputStream ois) throws IOException{
            byte[] temp = new byte[ois.readInt()];
            ois.read(temp);
            staticString = new String(temp);
        }
    }
}
