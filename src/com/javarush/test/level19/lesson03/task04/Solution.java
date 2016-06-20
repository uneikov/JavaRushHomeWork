package com.javarush.test.level19.lesson03.task04;

import com.javarush.test.level17.lesson10.bonus01.*;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution {


    public static class PersonScannerAdapter  implements PersonScanner {

        private Scanner personScanner;

        PersonScannerAdapter(Scanner scanner){
            this.personScanner = scanner;
        }

        public Person read() throws IOException{
             if (personScanner.hasNextLine())
             {
                 String[] line = personScanner.nextLine().split(" ");
                 int year = Integer.parseInt(line[5]) - 1900;
                 int month = Integer.parseInt(line[4])-1;
                 int day = Integer.parseInt(line[3]);
                 Date birthday = new Date(year, month, day);
                 return new Person(line[1], line[2], line[0], birthday);
             }
            else return null;
        }

        public void close() {
            personScanner.close();
        }
    }
}
