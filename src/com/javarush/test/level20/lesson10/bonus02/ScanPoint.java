package com.javarush.test.level20.lesson10.bonus02;

/**
 * Created by URAN on 20.05.2016.
 */
public class ScanPoint
{
    private int x;
    private int y;
    private Field field;
    private ScanDirection direction;

    public ScanPoint(int x, int y, Field field)
    {
        this.x = x;
        this.y = y;
        this.field = field;
        direction = ScanDirection.RIGHT;
    }

    public ScanDirection getDirection()
    {
        return direction;
    }

    public void setDirection(ScanDirection direction)
    {
        this.direction = direction;
    }

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public void move(){
        if (direction == ScanDirection.RIGHT) move(1);
        if (direction == ScanDirection.LEFT) move(-1);
    }
    private void move(int deltaX){
        x += deltaX;
    }
    public void moveDown(){
        y++;
    }
    public void returnToTheLeftBorder(){
        x = 0;
        moveDown();
    }
    public void reverseDirection(){
        switch (direction){
            case RIGHT: direction = ScanDirection.LEFT; break;
            case LEFT: direction = ScanDirection.RIGHT; break;
        }
    }
    public boolean crossedTheLeftBorder(){
        return x == -1;
    }
    public boolean onTheRightBorder(){
        return x == field.getWidth()-1;
    }
    public boolean crossedTheRightBorder(){
        return x == field.getWidth();
    }
    public boolean onTheTop(){
        return y == 0;
    }
    public boolean onTheBottom(){
        return y == field.getHeight()-1;
    }
    public  boolean crossedTheLeftEdge(){
        if ( x == 0 && field.getMatrix()[y][x] > 0 ) return true;
        if ( x != 0 && field.getMatrix()[y][x] > field.getMatrix()[y][x-1] ) return true;
        else  return false;
    }
    public boolean crossedTheRightEdge(){
        if (x == 0) return false;
        if ( x == field.getWidth()-1 && field.getMatrix()[y][x] > 0 ) return true;
        if ( field.getMatrix()[y][x] < field.getMatrix()[y][x-1] ) return true;
        else  return false;
    }
}
