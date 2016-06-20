package com.javarush.test.level05.lesson05.task02;

/* Реализовать метод fight
Реализовать метод boolean fight(Cat anotherCat):
реализовать механизм драки котов в зависимости от их веса, возраста и силы.
Зависимость придумать самому. Метод должен определять, выиграли ли мы (this) бой или нет,
т.е. возвращать true, если выиграли и false - если нет.
Должно выполняться условие:
если cat1.fight(cat2) = true , то cat2.fight(cat1) = false
*/

public class Cat
{
    public String name;
    public int age;
    public int weight;
    public int strength;

    public Cat()
    {
    }

    public boolean fight(Cat anotherCat)
    {
        int s1 =0;
        int s2 =0;
        if (this.age >= 2 && this.age <= 6)
            s1 = 2*this.weight * this.strength;
        else s1 = this.weight * this.strength;
        if (anotherCat.age >= 2 && anotherCat.age <= 6)
            s2 = 2*anotherCat.weight * anotherCat.strength;
        else s2 = anotherCat.weight * anotherCat.strength;
        if (s1 >= s2) return true;
        else return false;
    }
}

