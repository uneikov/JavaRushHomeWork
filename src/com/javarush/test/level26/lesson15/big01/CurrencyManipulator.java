package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.*;

public class CurrencyManipulator {

    private String currencyCode;
    private Map<Integer, Integer> denominations =new HashMap<>();

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void addAmount(int denomination, int count){
        if(denominations.containsKey(denomination))
            denominations.put(denomination, denominations.get(denomination) + count);
        else
            denominations.put(denomination,count);
    }

    public int getTotalAmount(){
        int sum = 0;
        for (Map.Entry<Integer, Integer> money : denominations.entrySet()){
            sum += money.getKey()*money.getValue();
        }
        return sum;
    }

    public boolean hasMoney(){
        return denominations.size() != 0;
    }

    public boolean isAmountAvailable(int expectedAmount){
        return expectedAmount <= getTotalAmount();
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException{

        int banknoteNumber;
        int tail = expectedAmount;
        Map<Integer, Integer> result = new HashMap<>();
        List<Integer> keys = new ArrayList<>(denominations.keySet());
        Collections.sort(keys, Collections.<Integer>reverseOrder());

        for (int i = 0; i < keys.size() ; i++) {
            banknoteNumber = tail / keys.get(i);
            tail %= keys.get(i);
            if (banknoteNumber != 0) result.put(keys.get(i), banknoteNumber);
        }

        if (tail != 0) throw new NotEnoughMoneyException();
        else{
            for (Map.Entry<Integer, Integer> r : result.entrySet()){
                addAmount(r.getKey(), - r.getValue());
            }
        }
        return result;
    }

}
