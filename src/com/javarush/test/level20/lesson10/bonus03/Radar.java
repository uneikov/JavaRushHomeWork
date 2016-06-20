package com.javarush.test.level20.lesson10.bonus03;

public class Radar {
    private int x;
    private int y;
    private int pointX;
    private int pointY;

    public Radar(){}

    public Radar(int x, int y)
    {
        this.x = x;
        this.y = y;
        pointX = x;
        pointY = y;
    }

    public void initRadar(){
        pointX = x - 1;
        pointY = y - 1;
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

    public int getPointX() {
        return pointX;
    }

    public void setPointX(int pointX) {
        this.pointX = pointX;
    }

    public int getPointY() {
        return pointY;
    }

    public void setPointY(int pointY) {
        this.pointY = pointY;
    }

    public void scanToOneStep(){
        if (pointX-x+1 < 2 && pointY-y+1 == 0) { pointX++; return; }
        if (pointX-x+1 <= 2 && pointY-y+1 == 2 && pointX-x+1 != 0) { pointX--; return; }
        if (pointY-y+1 < 2 && pointX-x+1 == 2) { pointY++; return; }
        if (pointY-y+1 <= 2 && pointX-x+1 == 0 && pointY-y+1 != 0) { pointY--; return; }
    }

    public boolean isScanned(){
        return pointX == x-1 && pointY == y - 1;
    }

    public Direction getDirection(int x, int y){
        if ( x == getPointX() && getPointY() - y == -1 ) return Direction.NORTH;
        if ( x == getPointX() && getPointY() - y == 1) return Direction.SOUTH;
        if ( y == getPointY() && getPointX() - x == -1) return Direction.WEST;
        if ( y == getPointY() && getPointX() - x == 1) return Direction.EAST;
        if ( getPointX() - x == -1 && getPointY() - y == -1) return Direction.NORTHWEST;
        if ( getPointX() - x == 1 && getPointY() - y == 1) return Direction.SOUTHEAST;
        if ( getPointX() - x == -1 && getPointY() - y == 1) return Direction.SOUTHWEST;
        if ( getPointX() - x == 1 && getPointY() - y == -1) return Direction.NORTHEAST;
        else return null;
    }

    public void moveTo(Direction direction){
        switch (direction){
            case NORTHWEST: { setPointX(getPointX() - 1); setPointY(getPointY() - 1); break; }
            case NORTH: { setPointY(getPointY() - 1); break; }
            case NORTHEAST: { setPointX(getPointX() + 1); setPointY(getPointY() - 1); break; }
            case EAST: { setPointX(getPointX() + 1); break; }
            case SOUTHEAST: { setPointX(getPointX() + 1); setPointY(getPointY() + 1); break; }
            case SOUTH: { setPointY(getPointY() + 1); break; }
            case SOUTHWEST: { setPointX(getPointX() - 1); setPointY(getPointY() + 1); break; }
            case WEST: { setPointX(getPointX() - 1); break; }
        }
    }
}

