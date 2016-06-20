package com.javarush.test.level20.lesson10.bonus02;

import java.util.ArrayList;

/* Алгоритмы-прямоугольники
1. Дан двумерный массив N*N, который содержит несколько прямоугольников.
2. Различные прямоугольники не соприкасаются и не накладываются.
3. Внутри прямоугольник весь заполнен 1.
4. В массиве:
4.1) a[i, j] = 1, если элемент (i, j) принадлежит какому-либо прямоугольнику
4.2) a[i, j] = 0, в противном случае
5. getRectangleCount должен возвращать количество прямоугольников.
6. Метод main не участвует в тестировании
*/
public class Solution {

    public static Field field;

    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 1, 0, 0, 0, 1},
                {1, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");
    }

    public static int getRectangleCount(byte[][] a) {

        field = new Field(a[0].length, a.length, a);
        ScanPoint scanner = new ScanPoint(0, 0, field);
        return getRectangles(scanner);
    }

    public static int getRectangles(ScanPoint scanner){

        int leftEdge = 0;
        Borders pattern;
        ArrayList<Borders> borders = new ArrayList<>();
        ArrayList<Rectangle> rectangles = new ArrayList<>();

        while (scanner.getX() < field.getWidth() && scanner.getY() < field.getHeight()){
            if (scanner.crossedTheLeftEdge()) leftEdge = scanner.getX();
            if (scanner.crossedTheRightEdge()) {
                if (scanner.onTheRightBorder())
                    borders.add(new Borders(leftEdge, scanner.getX(), scanner.getY()));
                else
                    borders.add(new Borders(leftEdge, scanner.getX()-1, scanner.getY()));
            }
            scanner.move();
            if (scanner.crossedTheRightBorder()) scanner.returnToTheLeftBorder();
        }

        int row = 0, originX, originY, rectWidth;
        while (borders.size() > 0){

            originX = borders.get(0).getLeftBorder();
            originY = borders.get(0).getRow();
            rectWidth = borders.get(0).getWidth();

            row++;
            pattern = borders.get(0);
            borders.remove(0);

            int k = 0;
            while (borders.size() > 0 && k < borders.size()){
                if (pattern.belongsToOneRectangle(borders.get(k))){
                    row++;
                    pattern = borders.get(k);
                    borders.remove(k);
                }
                else k++;
            }
            Rectangle next = new Rectangle(originX, originY, rectWidth, row);
            rectangles.add(next);
            row = 0;
        }

        //Rectangle rec =new Rectangle();
        //Rectangle.print(rectangles.get(0));
        //print(rectangles.get(1));
        return rectangles.size();
    }
}
