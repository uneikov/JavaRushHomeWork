package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так,
-- чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {

    public Solution() {}
    public Solution(int i) {}
    public Solution(String s) {}

    Solution(String s, int i) {}
    Solution(int i, String s) {}
    Solution(int i, String s1, String s2) {}

    protected Solution(int k, int i) {}
    protected Solution(int k, int i, int j) {}
    protected Solution(int i, int k, String s2) {}

    private Solution(byte b) {}
    private Solution(short sh) {}
    private Solution(Integer in) {}
}

