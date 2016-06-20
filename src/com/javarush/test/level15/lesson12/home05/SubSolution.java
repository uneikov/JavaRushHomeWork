package com.javarush.test.level15.lesson12.home05;

/**
 * Created by URAN on 27.03.2016.
 */
public class SubSolution extends Solution
{
    public SubSolution() {}

    public SubSolution(int i)
    {
        super(i);
    }

    public SubSolution(String s)
    {
        super(s);
    }

    SubSolution(String s, int i)
    {
        super(s, i);
    }

    SubSolution(int i, String s)
    {
        super(i, s);
    }

    SubSolution(int i, String s1, String s2)
    {
        super(i, s1, s2);
    }

    protected SubSolution(int k, int i)
    {
        super(k, i);
    }

    protected SubSolution(int k, int i, int j)
    {
        super(k, i, j);
    }

    protected SubSolution(int i, int k, String s2)
    {
        super(i, k, s2);
    }

    private SubSolution(byte b) { super(b);}
    private SubSolution(short s) {super(s);}
    private SubSolution(Integer in) {super(in);}
}
