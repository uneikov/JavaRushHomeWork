package com.javarush.test.level27.lesson15.big01.statistic.event;

import com.javarush.test.level27.lesson15.big01.ad.Advertisement;

import java.util.Date;
import java.util.List;



public class VideoSelectedEventDataRow implements EventDataRow{

    private List<Advertisement> optimalVideoSet;
    private long amount;
    private int totalDuration;
    private Date currentDate;

    public VideoSelectedEventDataRow(List<Advertisement> optimalVideoSet, long amount, int totalDuration) {
        this.optimalVideoSet = optimalVideoSet;
        this.amount = amount;
        this.totalDuration = totalDuration;
        this.currentDate = new Date();
    }

    public long getAmount() {
        return amount;
    }

    @Override
    public int getTime() {
        return totalDuration;
    }

    @Override
    public Date getDate() {
        return currentDate;
    }

    @Override
    public EventType getType() {
        return EventType.SELECTED_VIDEOS;
    }

}


