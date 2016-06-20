package com.javarush.test.level19.lesson03.task05;

import java.util.HashMap;
import java.util.Map;

/* Закрепляем адаптер
Адаптировать Customer и Contact к RowItem.
Классом-адаптером является DataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
*/

public class Solution {
    private static Map<String,String> countries = new HashMap<String,String>();
    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static class DataAdapter implements RowItem{

        private Customer dataAdapterCustomer;
        private Contact dataAdapterContact;

        public DataAdapter(Customer customer, Contact contact) {
            this.dataAdapterCustomer = customer;
            this.dataAdapterContact = contact;
        }

        public String  getContactFirstName(){
            return dataAdapterContact.getName().split(", ")[1];
        }
        public String  getContactLastName(){
            return dataAdapterContact.getName().split(", ")[0];
        }
        public String getCompany(){
            return dataAdapterCustomer.getCompanyName();
        }
        public String getCountryCode(){
            String country = dataAdapterCustomer.getCountryName();
            String key = null;
            for (Map.Entry<String, String> entry : countries.entrySet()) {
                if (country.equals(entry.getValue())) key = entry.getKey();
            }
            return key;
        }
        public String getDialString(){// это пиздец!!!
            return "callto://+" + dataAdapterContact.getPhoneNumber().replaceAll("[^0-9]","");
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
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