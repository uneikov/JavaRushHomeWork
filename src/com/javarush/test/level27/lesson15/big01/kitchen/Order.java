package com.javarush.test.level27.lesson15.big01.kitchen;


import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {

    private Tablet tablet;
    private List<Dish> dishes;

    public Order(Tablet tablet) throws IOException{
        this.tablet = tablet;
        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }

    public int getTotalCookingTime(){
        int result = 0;
        for (Dish dish :dishes) result += dish.getDuration();
        return result;
    }

    public boolean isEmpty() {
        return dishes.isEmpty();
    }

    @Override
    public String toString() {
        if (dishes.size() == 0) return "";
        else {
            return String.format("Your order: %s of %s", dishes.toString(), tablet.toString());
        }
    }
}
