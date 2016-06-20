package com.javarush.test.level20.lesson04.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Как сериализовать?
Сделайте так, чтобы сериализация класса Human была возможной
*/
public class Solution {
    public static class Human implements Serializable{
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }
        public void save(OutputStream outputStream) throws Exception {
            ObjectOutputStream objStream = new ObjectOutputStream(outputStream);
            if (name != null) objStream.writeObject(this);
            objStream.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            ObjectInputStream objStream = new ObjectInputStream(inputStream);
            Human human = (Human) objStream.readObject();
            this.name = human.name;
            this.assets = human.assets;
        }
    }
}
