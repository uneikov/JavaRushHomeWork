package com.javarush.test.level19.lesson03.task03;

/* Адаптация нескольких интерфейсов
Адаптировать IncomeData к Customer и Contact.
Классом-адаптером является IncomeDataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
Дополнить телефонный номер нулями до 10 цифр при необходимости (смотри примеры)
Обратите внимание на формат вывода фамилии и имени человека
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static class IncomeDataAdapter implements Customer, Contact {

        private IncomeData incomeData;
        IncomeDataAdapter(IncomeData iD){
            this.incomeData = iD;
        }
        public String getCompanyName(){
            return incomeData.getCompany();
        }
        public String getCountryName(){
            String countryCode = incomeData.getCountryCode();
            String countryName = countries.get(countryCode);
            return countryName;
        }
        public String getName(){
            return incomeData.getContactLastName() +", " + incomeData.getContactFirstName();
        }
        public String getPhoneNumber(){
            String code = "+" + incomeData.getCountryPhoneCode();
            String n = String.format("%010d", incomeData.getPhoneNumber());
            n = code + "(" + n.substring(0, 3) + ")" + n.substring(3, 6) + "-" + n.substring(6 ,8) + "-" +
                   n.substring(8, 10);
            return n;
        }
    }

    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }
}