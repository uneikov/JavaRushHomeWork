package com.javarush.test.level27.lesson15.big01;


import com.javarush.test.level27.lesson15.big01.statistic.StatisticManager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

public class DirectorTablet {

    public void printAdvertisementProfit(){

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        TreeMap<Date, Long> data = StatisticManager.getInstance().getAdvertisementProfit();
        long total = 0;

        if (data.isEmpty()) return;

        for (Map.Entry<Date, Long> event : data.entrySet()) {
            ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "%s - %.2f",
                    sdf.format(event.getKey()), 0.01d * event.getValue())
            );
            total += event.getValue();
        }

        ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "Total - %.2f", 0.01d * total));
    }

    public void printCookWorkloading(){

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        TreeMap<Date, TreeMap<String, Integer>> data = StatisticManager.getInstance().getCookWorkloading();

        if (data.isEmpty()) return;

        for (Map.Entry<Date, TreeMap<String, Integer>> treeMapEntry : data.entrySet()){
            ConsoleHelper.writeMessage(sdf.format(treeMapEntry.getKey()));
            for (Map.Entry<String, Integer> cookTime : treeMapEntry.getValue().entrySet()){
                ConsoleHelper.writeMessage( String.format( "%s - %d min",
                        cookTime.getKey(), (int) Math.ceil(cookTime.getValue()/60) )
                );
            }
            ConsoleHelper.writeMessage("");
        }
    }


    public void printActiveVideoSet(){

    }

    public void printArchivedVideoSet(){

    }
}
