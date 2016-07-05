package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.view.View;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by URAN on 04.07.2016.
 */
public class Model {

    private View view;
    private Provider[] providers;

    public Model(View view, Provider... providers) {

        if (view == null || providers == null)
        {
            throw new IllegalArgumentException();
        } else if (providers.length == 0)
        {
            throw new IllegalArgumentException();
        } else
        {
            this.view = view;
            this.providers = providers;
        }
    }

    public void selectCity(String city){
        List<Vacancy> allVacancies = new ArrayList<>();

        for (Provider provider : providers){

            allVacancies.addAll(provider.getJavaVacancies(city));

        }
        view.update(allVacancies);
    }
}
