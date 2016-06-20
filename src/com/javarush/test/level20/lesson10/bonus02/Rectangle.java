package com.javarush.test.level20.lesson10.bonus02;

/**
 * Created by URAN on 20.05.2016.
 */
public class Rectangle
{
    private int originX;
    private int originY;
    private int height;
    private int width;

    public Rectangle(){}
    public Rectangle(int originX, int originY, int width, int height)
    {
        this.originX = originX;
        this.originY = originY;
        this.width = width;
        this.height = height;
    }

    public int getOriginX()
    {
        return originX;
    }

    public void setOriginX(int originX)
    {
        this.originX = originX;
    }

    public int getOriginY()
    {
        return originY;
    }

    public void setOriginY(int originY)
    {
        this.originY = originY;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public void print(Rectangle rectangle){

        System.out.printf("Координаты начальной точки: x = %d y = %s, ширина: %s, высота: %s", originX, originY, width, height);
    }
}
