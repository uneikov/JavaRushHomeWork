package com.javarush.test.level05.lesson09.task05;

/* Создать класс прямоугольник (Rectangle)
Создать класс прямоугольник (Rectangle). Его данными будут top, left, width, height (левая координата, верхняя, ширина и высота). Создать для него как можно больше конструкторов:
Примеры:
-	заданы 4 параметра: left, top, width, height
-	ширина/высота не задана (оба равны 0)
-	высота не задана (равно ширине) создаём квадрат
-	создаём копию другого прямоугольника (он и передаётся в параметрах)
*/

public class Rectangle
{
    int top;
    int width;
    int left;
    int height;

    public Rectangle(int top, int left, int height, int width){
        this.top = top;
        this.height = height;
        this.left = left;
        this.width = width;
    }

    public Rectangle(int top, int left){
        this.top = top;
        this.height = 0;
        this.left = left;
        this.width = 0;
    }

    public Rectangle(int top, int left, int width){
        this.top = top;
        this.height = width;
        this.left = left;
        this.width = width;
    }

    public Rectangle(Rectangle rectangle){
        this.top = rectangle.top;
        this.height = rectangle.height;
        this.left = rectangle.left;
        this.width = rectangle.width;
    }

}
