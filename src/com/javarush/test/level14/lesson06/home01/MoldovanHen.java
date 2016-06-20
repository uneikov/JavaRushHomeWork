package com.javarush.test.level14.lesson06.home01;

class MoldovanHen extends Hen
{
    int getCountOfEggsPerMonth(){
        return 22;
    };
    String getDescription(){
        return  super.getDescription()+" Моя страна - " + Country.MOLDOVA +
                ". Я несу "+ getCountOfEggsPerMonth()+ " яиц в месяц";
    }
}