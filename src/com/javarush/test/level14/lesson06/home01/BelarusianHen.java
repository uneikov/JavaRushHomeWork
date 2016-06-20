package com.javarush.test.level14.lesson06.home01;

class BelarusianHen extends Hen
{
    int getCountOfEggsPerMonth(){
        return 25;
    };
    String getDescription(){
        return  super.getDescription()+" Моя страна - "+ Country.BELARUS  +
                ". Я несу "+ getCountOfEggsPerMonth()+ " яиц в месяц";
    }
}
