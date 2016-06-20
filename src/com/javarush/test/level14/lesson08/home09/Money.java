package com.javarush.test.level14.lesson08.home09;

public abstract class Money
{
    private double amount;

    public Money(){} // Дефолтный конструктор без параметров

    public Money(double amount)
    {
        this.amount = amount;
    }

    public double getAmount() { return amount;}

    public abstract String getCurrencyName();
}

// Класс должен иметь конструктор. Усли класс не имеет конструктора, то неявно вызывается дефолтный
// конструктор без параметров суперкласса. Если такового у суперкаласса нет, то выдается сообщение
// об ошибке со стороны компилятора Java