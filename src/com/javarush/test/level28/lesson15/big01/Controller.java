package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.Provider;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


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
            try {
                currentVacancies = currentProvider.getJavaVacancies("kiev");
                if(!currentVacancies.isEmpty())allVacancies.addAll(currentVacancies);
                currentVacancies.clear();
            }catch (NullPointerException npe) {}
        }
        System.out.println(allVacancies.size());

    }
}
