package com.javarush.test.level27.lesson15.big01.kitchen;

public enum  Dish {
    Fish(25),
    Steak(30),
    Soup(15),
    Juice(5),
    Water(3);

    private int duration;

    private Dish(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public static String allDishesToString(){

        Dish[] dishes = Dish.values();
        StringBuilder dishesString = new StringBuilder().append(dishes[0]);
        for (int i = 1; i < dishes.length ; i++) {
            dishesString.append(", ").append(dishes[i].toString());
        }
        return dishesString.toString();
    }
}
