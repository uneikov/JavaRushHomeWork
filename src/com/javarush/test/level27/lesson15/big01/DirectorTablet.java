package com.javarush.test.level27.lesson15.big01;


import com.javarush.test.level27.lesson15.big01.ad.Advertisement;
import com.javarush.test.level27.lesson15.big01.ad.StatisticAdvertisementManager;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;

import java.text.SimpleDateFormat;
import java.util.*;

public class DirectorTablet {

    public void printAdvertisementProfit(){

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        TreeMap<Date, Long> data = StatisticEventManager.getInstance().getAdvertisementProfit();
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
        TreeMap<Date, TreeMap<String, Integer>> data = StatisticEventManager.getInstance().getCookWorkloading();

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
        List<Advertisement> videoSet = StatisticAdvertisementManager.getInstance().getActiveVideoSet();
        Collections.sort(videoSet, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
        for (Advertisement ad : videoSet) {
            ConsoleHelper.writeMessage(String.format("%s - %d", ad.getName(), ad.getHits())
            );
        }
    }

    public void printArchivedVideoSet(){
        List<Advertisement> videoSet = StatisticAdvertisementManager.getInstance().getArhivedVideoSet();
        Collections.sort(videoSet, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
        for (Advertisement ad : videoSet) {
            ConsoleHelper.writeMessage(ad.getName()
            );
        }
    }
}
