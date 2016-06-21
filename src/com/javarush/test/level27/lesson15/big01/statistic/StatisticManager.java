package com.javarush.test.level27.lesson15.big01.statistic;


import com.javarush.test.level27.lesson15.big01.statistic.event.EventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticManager {
    private static StatisticManager ourInstance = new StatisticManager();
    private StatisticStorage statisticStorage = new StatisticStorage();

    public static StatisticManager getInstance() {
        return ourInstance;
    }

    private StatisticManager() {
    }

    public void register(EventDataRow data){
        statisticStorage.put(data);
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

    }
}
