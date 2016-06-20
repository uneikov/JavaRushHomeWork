package com.javarush.test.level20.lesson10.home03;

import java.io.*;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите проблему и исправьте ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
Метод main не участвует в тестировании.
*/

public class Solution  {

    public static class A {
        protected String name = "A";

        public A(){} // добавлен конструктор без параметров

        public A(String name) {
            this.name += name;
        }
    }

    public class B extends A implements Serializable {


        public B(String name) {
            super(name);
            this.name += name;
        }

        private void writeObject(ObjectOutputStream out) throws IOException {

            out.writeObject(this.name); // переопределен метод - выгрузка в ручном режиме
        }

        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {

            this.name = (String )in.readObject(); // переопределен метод - загрузка в ручном режиме
        }
    }
}
