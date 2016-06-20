package com.javarush.test.level20.lesson10.bonus03;

import java.util.ArrayList;

public class SeekPoint
{
    private int x;
    private int y;
    private int symbol;
    private String word;
    private ArrayList<Direction> directions;

    public SeekPoint(){
    }

    public SeekPoint( int x, int y, String word, ArrayList<Direction> directions ) {
        this.x = x;
        this.y = y;
        this.word = word;
        this.symbol = word.charAt(0);
        this.directions = directions;
    }

    public String getWord() {
        return word;
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSymbol() {
        return symbol;
    }

    public void setSymbol(int symbol) {
        this.symbol = symbol;
    }

    public ArrayList<Direction> getDirections() {
        return directions;
    }
}
