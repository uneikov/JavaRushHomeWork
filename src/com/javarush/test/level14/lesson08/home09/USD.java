package com.javarush.test.level14.lesson08.home09;

// Класс должен иметь конструктор. Усли класс не имеет конструктора, то неявно вызывается дефолтный
// конструктор без параметров суперкласса. Если такового нет, то выдается сообщение об ошибке со стороны
// компилятора Java

public class USD extends Money
{
    public  String getCurrencyName() {return "USD";}
}
