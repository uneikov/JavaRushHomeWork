package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
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

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User userFirst = new User();
            GregorianCalendar cal = new GregorianCalendar(1996, 11, 3);
            userFirst.setFirstName("Peter");
            userFirst.setLastName("Uagadugu");
            userFirst.setMale(true);
            userFirst.setCountry(User.Country.RUSSIA);
            userFirst.setBirthDate(cal.getTime());
            javaRush.users.add(userFirst);

            User user2 = new User();
            GregorianCalendar cal1 = new GregorianCalendar(2001, 10, 4);
            user2.setFirstName("Ilia");
            user2.setLastName("Makarov");
            user2.setMale(true);
            user2.setCountry(User.Country.UKRAINE);
            user2.setBirthDate(cal1.getTime());
            javaRush.users.add(user2);
            //---------------------------------
            javaRush.save(outputStream);
            outputStream.flush();
            //---------------------------------
            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            System.out.println(loadedObject.users.get(0).getFirstName() + " : " +loadedObject.users.get(0).getLastName() + " : "
            + loadedObject.users.get(0).isMale() + " : " + loadedObject.users.get(0).getCountry()
                    + " : " + loadedObject.users.get(0).getBirthDate());
            System.out.println(loadedObject.users.get(1).getFirstName() + " : " +loadedObject.users.get(1).getLastName() + " : "
            + loadedObject.users.get(1).isMale() + " : " + loadedObject.users.get(1).getCountry()
                   + " : " + loadedObject.users.get(1).getBirthDate());

            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {

        public List<User> users = new ArrayList<>();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH); // без этого не идет!!!

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter printWriter = new PrintWriter(outputStream);
            if (users.size() != 0) {
                for (User user : users)
                {
                    printWriter.print(user.getFirstName() + ",");
                    printWriter.print(user.getLastName() + ",");
                    printWriter.print(user.isMale() + ",");
                    printWriter.print(user.getCountry().getDisplayedName() + ",");
                    printWriter.print(dateFormat.format(user.getBirthDate()) + ",");
                    printWriter.println();
                }
            }
            printWriter.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            String next;
            String[] nextLine;
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            while ((next = br.readLine()) != null){
                User loadedUser = new User();
                nextLine = next.split(",");
                loadedUser.setFirstName(nextLine[0]);
                loadedUser.setLastName(nextLine[1]);
                loadedUser.setMale(Boolean.parseBoolean(nextLine[2]));
                loadedUser.setCountry(User.Country.valueOf(nextLine[3].toUpperCase()));
                loadedUser.setBirthDate(dateFormat.parse(nextLine[4]));
                users.add(loadedUser);
            }
        }
    }
}
