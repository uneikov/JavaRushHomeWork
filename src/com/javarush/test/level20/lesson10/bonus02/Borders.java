package com.javarush.test.level20.lesson10.bonus02;

/**
 * Created by URAN on 20.05.2016.
 */
public class Borders
{
    private int row;
    private int leftBorder;
    private int rightBorder;
    private int width;

    public Borders(int leftBorder, int rightBorder, int row)
    {
        this.row = row;
        this.leftBorder = leftBorder;
        this.rightBorder = rightBorder;
    }

    public int getWidth()
    {
        if (leftBorder == rightBorder) return  1;
        else return rightBorder - leftBorder;
    }

    public int getLeftBorder()
    {
        return leftBorder;
    }

    public int getRow()
    {
        return row;
    }

    public void setRow(int row)
    {
        this.row = row;
    }

    public void setLeftBorder(int leftBorder)
    {
        this.leftBorder = leftBorder;
    }

    public int getRightBorder()
    {
        return rightBorder;
    }

    public void setRightBorder(int rightBorder)
    {
        this.rightBorder = rightBorder;
    }

    public boolean belongsToOneRectangle(Borders border)
    {
        if (this.leftBorder == border.leftBorder &&
                this.rightBorder == border.rightBorder &&
                Math.abs(border.row - this.row) <= 1) return true;
        else return false;
    }
}
