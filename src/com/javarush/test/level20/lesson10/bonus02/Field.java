package com.javarush.test.level20.lesson10.bonus02;

/**
 * Created by URAN on 20.05.2016.
 */
public class Field
{
    private int width;
    private int height;
    private byte[][] matrix;

    public Field(int width, int height, byte[][] matrix)
    {
        this.width = width;
        this.height = height;
        this.matrix = matrix;
    }

    public byte[][] getMatrix()
    {
        return matrix;
    }

    public void setMatrix(byte[][] matrix)
    {
        this.matrix = matrix;
    }

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public void print(){
        for (int row = 0; row < height; row++){
            for (int column = 0; column < width; column++){
                System.out.print(matrix[row][column] + " ");
            }
            System.out.println();
        }
    }
}
