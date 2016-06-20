package com.javarush.test.level24.lesson09.task02;

import java.text.ChoiceFormat;
import java.text.Format;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/* Знания - сила!
1. В методе sort написать компаратор для Stock:
1.1. Первичная сортировка по name в алфавитном порядке
1.2. Вторичная сортировка по дате без учета часов, минут, секунд (сверху самые новые), потом по прибыли от положительных к отрицательным
... open 125,64 and last 126,74 - тут прибыль = 126,74-125,64
... open 125,64 and last 123,43 - тут прибыль = 123,43-125,64
2. Разобраться с *Format-ами и исправить IllegalArgumentException. Подсказка - это одна строчка.
Пример вывода:
Fake Apple Inc.   AAPL | 17-11-2025 open 125,64 and last 123,43
Fake Oracle Corporation   ORCL | 21-08-1989 closed 0,15
*/

public class Solution {

    public static Date now = new Date();

    public static void main(String[] args) {
        List<Stock> stocks = getStocks();
        sort(stocks);
        Date actualDate = new Date();
        printStocks(stocks, actualDate);
    }

    public static void printStocks(List<Stock> stocks, Date actualDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        double[] filelimits = {0d, actualDate.getTime()};
        String[] filepart = {"closed {4}", "open {2} and last {3}"};

        ChoiceFormat fileform = new ChoiceFormat(filelimits, filepart);
        Format[] testFormats = {null, null, dateFormat, fileform}; // добавил второй null для name & symbol
        MessageFormat pattform = new MessageFormat("{0}   {1} | {5} {6}");
        pattform.setFormats(testFormats);

        for (Stock stock : stocks) {
            String name = (String) stock.get("name");
            String symbol = (String) stock.get("symbol");
            double open = !stock.containsKey("open") ? 0 : ((double) stock.get("open"));
            double last = !stock.containsKey("last") ? 0 : ((double) stock.get("last"));
            double change = !stock.containsKey("change") ? 0 : ((double) stock.get("change"));
            Date date = (Date) stock.get("date");
            Object[] testArgs = {name, symbol, open, last, change, date, date.getTime()};
            System.out.println(pattform.format(testArgs));
        }
    }

    public static void sort(List<Stock> list) {
        Collections.sort(list, new Comparator<Stock>()
        { // компаратор написан мной
            public int compare(Stock stock1, Stock stock2)  {
                int result;
                String str1 = (String) stock1.get("name");
                String str2 = (String) stock2.get("name");
                result = str1.compareTo(str2);
                if(result != 0) return result;
                // если имена одинаковые - сравниваем даты
                Long  date1 = ((Date) stock1.get("date")).getTime() / (24 * 60 * 60 * 1000);
                Long  date2 = ((Date) stock2.get("date")).getTime() / (24 * 60 * 60 * 1000);
                if ( !date1.equals(date2) ) return date1 > date2 ? -1 : 1;
                // если даты одинаковые - сравниваем изменения цены акций
                Double change1 = getChange(stock1);
                Double change2 = getChange(stock2);
                if ( !change1.equals(change2) ) return change1 > change2 ? -1 : 1;
                else return  0;
            }
            private double getChange(Stock stock) {
                if (stock.containsKey("change")) return (double)stock.get("change");
                else return (double)stock.get("last") - (double)stock.get("open");
            }
        }
        );
    }

    public static class Stock extends HashMap {
        public Stock(String name, String symbol, double open, double last) {
            put("name", name);
            put("symbol", symbol);
            put("open", open);
            put("last", last);
            put("date", getRandomDate(2020));
        }

        public Stock(String name, String symbol, double change, Date date) {
            put("name", name);
            put("symbol", symbol);
            put("date", date);
            put("change", change);
        }
    }

    public static List<Stock> getStocks() {
        List<Stock> stocks = new ArrayList();

        stocks.add(new Stock("Fake Apple Inc.", "AAPL", 125.64, 123.43));
        stocks.add(new Stock("Fake Cisco Systems, Inc.", "CSCO", 25.84, 26.3));
        stocks.add(new Stock("Fake Google Inc.", "GOOG", 516.2, 512.6));
        stocks.add(new Stock("Fake Intel Corporation", "INTC", 21.36, 21.53));
        stocks.add(new Stock("Fake Level 3 Communications, Inc.", "LVLT", 5.55, 5.54));
        stocks.add(new Stock("Fake Microsoft Corporation", "MSFT", 29.56, 29.72));

        stocks.add(new Stock("Fake Nokia Corporation (ADR)", "NOK", .1, getRandomDate()));
        stocks.add(new Stock("Fake Oracle Corporation", "ORCL", .15, getRandomDate()));
        stocks.add(new Stock("Fake Starbucks Corporation", "SBUX", .03, getRandomDate()));
        stocks.add(new Stock("Fake Yahoo! Inc.", "YHOO", .32, getRandomDate()));
        stocks.add(new Stock("Fake Applied Materials, Inc.", "AMAT", .26, getRandomDate()));
        stocks.add(new Stock("Fake Comcast Corporation", "CMCSA", .5, getRandomDate()));
        stocks.add(new Stock("Fake Sirius Satellite", "SIRI", -.03, getRandomDate()));

        return stocks;
    }

    public static Date getRandomDate() {
        return getRandomDate(1970);
    }

    public static Date getRandomDate(int startYear) {
        int year = startYear + (int) (Math.random() * 30);
        int month = (int) (Math.random() * 12);
        int day = (int) (Math.random() * 28);
        GregorianCalendar calendar = new GregorianCalendar(year, month, day);
        return calendar.getTime();
    }
}

