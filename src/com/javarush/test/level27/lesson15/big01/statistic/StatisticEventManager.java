package com.javarush.test.level27.lesson15.big01.statistic;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;

import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventType;
import com.javarush.test.level27.lesson15.big01.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

public class StatisticEventManager {
    private static StatisticEventManager ourInstance = new StatisticEventManager();
    private StatisticStorage statisticStorage = new StatisticStorage();
    private Set<Cook> cooks = new HashSet<>();

    public static StatisticEventManager getInstance() {
        return ourInstance;
    }

    private StatisticEventManager() {
    }

    public void register(EventDataRow data){
        if (data == null) return;
        statisticStorage.put(data);
    }

    public void register(Cook cook){
        cooks.add(cook);
    }

    public Set<Cook> getCooks() {
        return cooks;
    }

    private class StatisticStorage {

        private Map<EventType, List<EventDataRow>> eventMapStorage = new HashMap<>();

        public StatisticStorage() {
            for (EventType type : EventType.values()){
                eventMapStorage.put(type,new ArrayList<EventDataRow>());
            }
        }

        private void put(EventDataRow data){
            eventMapStorage.get(data.getType()).add(data);
        }

        private List<EventDataRow> getEvents(EventType eventType) {
            return eventMapStorage.get(eventType);
        }
    }

    private  Date removeTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public TreeMap<Date, Long> getAdvertisementProfit() {
        TreeMap<Date, Long> result = new TreeMap<>();
        long amount;
        Date date;

        for (EventDataRow video : statisticStorage.getEvents(EventType.SELECTED_VIDEOS)) {
            amount = ((VideoSelectedEventDataRow) video).getAmount();
            date = removeTime(video.getDate());

            if (result.containsKey(date)) {
                result.put(date, result.get(date) + amount);
            } else {
                result.put(date, amount);
            }
        }

        return result;
    }

    public TreeMap<Date, TreeMap<String, Integer>> getCookWorkloading(){

        TreeMap<Date, TreeMap<String, Integer>> result = new TreeMap<>();
        TreeMap<String, Integer> cookWork= new TreeMap<>();
        String cookName;
        Date date;

        for (EventDataRow orders : statisticStorage.getEvents(EventType.COOKED_ORDER)) {
            cookName = ((CookedOrderEventDataRow) orders).getCookName();
            date = removeTime(orders.getDate());
            if (result.containsKey(date)) {
                if (cookWork.containsKey(cookName))
                    cookWork.put(cookName, cookWork.get(cookName) + orders.getTime());
                else
                    cookWork.put(cookName,  orders.getTime());
            } else {
                cookWork = new TreeMap<>();
                cookWork.put(cookName, orders.getTime());
                result.put(date, cookWork);
            }
        }

        return result;
    }
}
