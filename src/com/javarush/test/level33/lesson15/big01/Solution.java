package com.javarush.test.level33.lesson15.big01;

import com.javarush.test.level33.lesson15.big01.strategies.HashMapStorageStrategy;
import com.javarush.test.level33.lesson15.big01.strategies.StorageStrategy;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by URAN on 31.07.2016.
 */
public class Solution {
    public static Set<Long> getIds(Shortener shortener, Set<String> strings){

        Set<Long> result = new HashSet<>();

        for (String id : strings){
            result.add(shortener.getId(id));
        }

        return result;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys){

        Set<String> result = new HashSet<>();

        for (Long key : keys){
            result.add(shortener.getString(key));
        }

        return result;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber){

        Helper.printMessage(strategy.getClass().getSimpleName());

        Set<String> randomSet = new HashSet<>();
        for (int i = 0; i < elementsNumber; i++) {
            randomSet.add(Helper.generateRandomString());
        }

        Shortener shortener = new Shortener(strategy);

        Set<Long> keysSet;

        long startTime = new Date().getTime();
        keysSet = getIds(shortener, randomSet);
        long elapsedTime = new Date().getTime()- startTime;

        System.out.println(String.format("Time in seconds: %10.4f", (float)elapsedTime/1000));

        Set<String> _randomSet;

        startTime = new Date().getTime();
        _randomSet = getStrings(shortener, keysSet);
        elapsedTime = new Date().getTime()- startTime;

        System.out.println(String.format("Time in seconds: %10.4f", (float)elapsedTime/1000));

        if (randomSet.equals(_randomSet))
            Helper.printMessage("Тест пройден.");
        else
            Helper.printMessage("Тест не пройден.");
    }

    public static void main(String[] args) {
        testStrategy(new HashMapStorageStrategy(), 10000);
    }
}
