package com.javarush.test.level15.lesson12.home04;

/* Закрепляем Singleton pattern
1. Найти в гугле пример для - Singleton pattern Lazy initialization.
2. По образу и подобию в отдельных файлах создать три синглтон класса Sun, Moon, Earth.
3. Реализовать интерфейс Planet для классов Sun, Moon, Earth.
4. В статическом блоке класса Solution вызвать метод readKeyFromConsoleAndInitPlanet.
5. Реализовать функционал метода readKeyFromConsoleAndInitPlanet:
5.1. С консоли считать один параметр типа String.
5.2. Если параметр равен одной из констант интерфейса Planet,
     то создать соответствующий объект и присвоить его Planet thePlanet, иначе обнулить Planet thePlanet.
5.3. Сравнивать введенный параметр можно только с константами из Planet, нельзя создавать свои строки.
*/

import java.util.Scanner;

public class Solution {
    public static Planet thePlanet;
    static { readKeyFromConsoleAndInitPlanet();}

    public static void readKeyFromConsoleAndInitPlanet() {

        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();

        if (Planet.EARTH.equals(in.toLowerCase())) thePlanet = Earth.getInstance();
        else {
            if (Planet.MOON.equals(in.toLowerCase())) thePlanet = Moon.getInstance();
            else {
                if (Planet.SUN.equals(in.toLowerCase())) thePlanet = Sun.getInstance();
                else thePlanet = null;}}

    }
}
