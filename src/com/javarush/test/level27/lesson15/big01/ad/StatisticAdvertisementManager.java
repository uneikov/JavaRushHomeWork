package com.javarush.test.level27.lesson15.big01.ad;


import java.util.ArrayList;
import java.util.List;

public class StatisticAdvertisementManager {

    private static StatisticAdvertisementManager ourInstance = new StatisticAdvertisementManager();
    private AdvertisementStorage advertisementStorage = AdvertisementStorage.getInstance();

    public static StatisticAdvertisementManager getInstance() {
        return ourInstance;
    }

    private StatisticAdvertisementManager() {
    }

    public List<Advertisement> getActiveVideoSet(){
        List<Advertisement> activeSet = new ArrayList<>();
        for (Advertisement ad : advertisementStorage.list()){
            if (ad.getHits() > 0) activeSet.add(ad);
        }
        return activeSet;
    }

    public List<Advertisement> getArhivedVideoSet(){
        List<Advertisement> archivedVideoSet = new ArrayList<>();
        for (Advertisement ad : advertisementStorage.list()){
            if (ad.getHits() == 0) archivedVideoSet.add(ad);
        }
        return archivedVideoSet;
    }
}
