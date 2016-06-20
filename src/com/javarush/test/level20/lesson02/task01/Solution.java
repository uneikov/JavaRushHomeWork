package com.javarush.test.level20.lesson02.task01;

import java.io.*;
import java.util.*;

/* Читаем и пишем в файл: Human
Реализуйте логику записи в файл и чтения из файла для класса Human
Поле name в классе Human не может быть пустым
В файле your_file_name.tmp может быть несколько объектов Human
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {

            File your_file_name = File.createTempFile("test", null);
            OutputStream outputStream = new FileOutputStream(your_file_name, true);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
            ivanov.save(outputStream);
            outputStream.flush();

            Human petrov = new Human("Petrov", new Asset("villa"), new Asset("supercar"));
            petrov.save(outputStream);
            outputStream.flush();

            outputStream.close();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            System.out.println(somePerson.name + " : " + somePerson.assets.get(0).getName() + " & " + somePerson.assets.get(1).getName());
          // это не работает - теряется позиция в потоке inputStream !!!
            //somePerson = new Human();
           // somePerson.load(inputStream);
            //System.out.println(somePerson.name + " : " + somePerson.assets.get(0).getName() + " & " + somePerson.assets.get(1).getName());

            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }


    public static class Human {
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
            PrintWriter printWriter = new PrintWriter(outputStream);
            if (name != null) {
                printWriter.print(name + " ");
                printWriter.print(assets.size() + " ");
                for (Asset asset : assets) {
                    printWriter.print(asset.getName() + " ");
                    printWriter.print(asset.getPrice() + " ");
                }
            }
            printWriter.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            int assetSize;
            String personName, assetName;
            Double  price;
            Scanner scanner = new Scanner(inputStream).useLocale(Locale.ENGLISH);
            personName = scanner.next();
            assetSize = scanner.nextInt();
            for (int i = 0; i < assetSize; i++){
                assetName = scanner.next();
                price = scanner.nextDouble();
                Asset asset = new Asset(assetName);
                asset.setPrice(price);
                assets.add(asset);
            }
            this.name = personName;
        }
    }
}
