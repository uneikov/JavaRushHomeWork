package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.Model;


public class Controller {

    Model model;

    public Controller(Model model) {

        if (model == null)
            throw new IllegalArgumentException();
        else
            this.model = model;
    }

    public void onCitySelect(String cityName){

        model.selectCity(cityName);

    }
}
