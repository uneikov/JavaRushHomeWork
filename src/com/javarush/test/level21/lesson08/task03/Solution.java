package com.javarush.test.level21.lesson08.task03;

/* Запретить клонирование
Разрешите клонировать класс А
Запретите клонировать класс B
Разрешите клонировать класс C
Метод main не участвует в тестировании.
*/
public class Solution {

    public static void main(String[] args){

        A newA = new A(1, 1);
        B newB = new B(2, 2, "B");
        C newC = new C(3, 3, "C");
        A clonedA = null;
        B clonedB = null;
        C clonedC = null;
        try
        {
            clonedA = (A) newA.clone();
            //clonedB = (B) newB.clone();
            clonedC = (C) newC.clone();
            //clonedA.i = 100;
            //clonedB.name = "BB";
            System.out.println(newA.getI() + "A" + " : " + clonedA.getI() + "A");
            System.out.println(newB.getI() + newB.getName());
            System.out.println(newC.getI() + newC.getName() + " : " + clonedC.getI() + clonedC.getName());

        }catch (CloneNotSupportedException ex) {ex.printStackTrace();}
    }

    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        @Override // переопределяем клонирование для A
        public Object clone() throws CloneNotSupportedException
        {
            return super.clone();
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public Object clone() throws CloneNotSupportedException
        {
            throw new CloneNotSupportedException(); // запрет клонирования
        }
    }

    public static class C extends B implements Cloneable{
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        @Override // переопределяем клонирование для C
        public Object clone() throws CloneNotSupportedException
        {
            return new C(super.getI(), super.getJ() , super.getName());
        }
    }
}
