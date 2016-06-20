package com.javarush.test.level15.lesson12.home10;

/* ООП - наследование
Исправить класс Hrivna так, чтоб избежать ошибку StackOverflowError, класс Money менять нельзя.
*/

import com.javarush.test.level14.lesson08.home09.Hrivna;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Hrivna().getAmount());
    }

    public static abstract class Money {

        abstract Money getMoney();

        public Object getAmount() {
            return getMoney().getAmount();
        }
    }

    public static class Hrivna extends Money {
        public double amount = 123d;
        public Object getAmount() {return this.amount;} // добавил эту строку
        public Hrivna getMoney() {
            return this;
        }
    }
}
