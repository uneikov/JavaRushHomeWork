package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.Provider;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by URAN on 02.07.2016.
 */
public class Controller {

    private Provider[] providers;

    public Controller(Provider... providers) {

        if (providers.length == 0)
            throw new IllegalArgumentException();
        else
            this.providers = providers;
    }

    @Override
    public String toString() {
        return "Controller{" +
                "providers=" + Arrays.toString(providers) +
                '}';
    }

    public void scan() {

        List<Vacancy> allVacancies = new ArrayList<>();

        List<Vacancy> currentVacancies;
        for (Provider currentProvider : providers){
            currentVacancies = currentProvider.getJavaVacancies("java Киев");
            try {
                allVacancies.addAll(currentVacancies);
            }catch (NullPointerException npe) {}
        }
        System.out.println(allVacancies.size());
    }
}
