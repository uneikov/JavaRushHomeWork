package com.javarush.test.level03.lesson04.task03;

/* StarCraft
Создать 10 зергов, 5 протосов и 12 терран.
Дать им всем уникальные имена.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Zerg zerg1 = new Zerg();
        zerg1.name="zero";
        Zerg zerg2 = new Zerg();
        zerg1.name="first";
        Zerg zerg3 = new Zerg();
        zerg1.name="second";
        Zerg zerg4 = new Zerg();
        zerg1.name="third";
        Zerg zerg5 = new Zerg();
        zerg1.name="forth";
        Zerg zerg6 = new Zerg();
        zerg1.name="fifth";
        Zerg zerg7 = new Zerg();
        zerg1.name="sixth";
        Zerg zerg8 = new Zerg();
        zerg1.name="seventh";
        Zerg zerg9 = new Zerg();
        zerg1.name="eigth";
        Zerg zerg10 = new Zerg();
        zerg1.name="nineth";

        Protos protos1 = new Protos();
        protos1.name = "pipi";
        Protos protos2 = new Protos();
        protos1.name = "zizi";
        Protos protos3 = new Protos();
        protos1.name = "mimi";
        Protos protos4 = new Protos();
        protos1.name = "titi";
        Protos protos5 = new Protos();
        protos1.name = "lili";

        Terran terran1 = new Terran();
        terran1.name = "T1";
        Terran terran2 = new Terran();
        terran1.name = "T2";
        Terran terran3 = new Terran();
        terran1.name = "T3";
        Terran terran4 = new Terran();
        terran1.name = "T4";
        Terran terran5 = new Terran();
        terran1.name = "T5";
        Terran terran6 = new Terran();
        terran1.name = "T6";
        Terran terran7 = new Terran();
        terran1.name = "T7";
        Terran terran8 = new Terran();
        terran1.name = "T8";
        Terran terran9 = new Terran();
        terran1.name = "T9";
        Terran terran10 = new Terran();
        terran1.name = "T10";
        Terran terran11 = new Terran();
        terran1.name = "T11";
        Terran terran12 = new Terran();
        terran1.name = "T12";

    }

    public static class Zerg
    {
        public String name;
    }

    public static class Protos
    {
        public String name;
    }

    public static class Terran
    {
        public String name;
    }
}