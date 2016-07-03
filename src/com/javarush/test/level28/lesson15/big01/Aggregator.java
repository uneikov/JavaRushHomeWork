package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.HHStrategy;
import com.javarush.test.level28.lesson15.big01.model.Provider;


/**
 * Created by URAN on 02.07.2016.
 */
public class Aggregator {
    public static void main(String[] args) {

        Provider hhProvider = new Provider(new HHStrategy());

        Controller controller = new Controller(hhProvider);

        controller.scan();
    }
}
