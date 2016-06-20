package com.javarush.test.level20.lesson10.home07;

import java.io.*;

/* Переопределение сериализации в потоке
Сериализация/десериализация Solution не работает.
Исправьте ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать экземпляр класса Solution
2) записать в него данные  - writeObject
3) сериализовать класс Solution  - writeObject(ObjectOutputStream out)
4) десериализовать, получаем новый объект
5) записать в новый объект данные - writeObject
6) проверить, что в файле есть данные из п.2 и п.5
*/
// РАЗ МЫ НЕ МОЖЕМ СЕРИАЛИЗОВАТЬ ПОТОК, СЕРИАЛИЗУЕМ/ДЕСЕРИАЛИЗУЕМ ИМЯ ФАЙЛА!



public class Solution implements Serializable, AutoCloseable {

    private transient FileOutputStream stream;
    private transient String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.fileName = fileName; // добавили переменную
        this.stream = new FileOutputStream(fileName, true);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {

        out.writeObject(fileName); // сохраняем имя файла
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {

        fileName = (String) in.readObject(); // сохраняем имя файла
        stream = new FileOutputStream(fileName, true); // восстанавливаем поток по имени файла
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }
}
