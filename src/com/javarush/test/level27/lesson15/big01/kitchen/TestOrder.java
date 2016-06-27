package com.javarush.test.level27.lesson15.big01.kitchen;


import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.ArrayList;

public class TestOrder extends Order{

    public TestOrder(Tablet tablet) throws IOException {
        super(tablet);
    }

    @Override
    protected void initDishes() {
        dishes = new ArrayList<>();
        Dish[] dishs = Dish.values();
        int randomDish;

        ConsoleHelper.writeMessage(Dish.allDishesToString());

        for (int i = 0; i < dishs.length ; i++) {
            randomDish = (int) Math.round((dishs.length-1) * Math.random());
            dishes.add(dishs[randomDish]);
        }

    }
}
