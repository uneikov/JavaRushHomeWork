package com.javarush.test.level20.lesson10.home09;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* Знакомство с графами
Прочитать в дополнительных материалах о сериализации графов.
Дан ориентированный плоский граф Solution, содержащий циклы и петли.
Пример, http://edu.nstu.ru/courses/saod/images/graph1.gif
Сериализовать Solution.
Все данные должны сохранить порядок следования.
*/
public class Solution implements Serializable{ // нужно было добавить только это!!!
    int node;
    List<Solution> edges = new LinkedList<>(); // список ребер

    public static void main(String[] args){
        // добавляем в список ребра с указанием изкакого узла и в какой узел они направлены
        Solution solution = new Solution();
        solution.node = 6;
        solution.edges.add(new Solution(1, 2));
        solution.edges.add(new Solution(2, 2));
        solution.edges.add(new Solution(2, 4));
        solution.edges.add(new Solution(2, 5));
        solution.edges.add(new Solution(4, 1));
        solution.edges.add(new Solution(4, 5));
        solution.edges.add(new Solution(5, 4));
        solution.edges.add(new Solution(6, 3));
        try
        {
            FileOutputStream fos = new FileOutputStream("test");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(solution);
            fos.close(); oos.close();
            solution = new Solution();
            FileInputStream fis = new FileInputStream("test");
            ObjectInputStream ois = new ObjectInputStream(fis);
            solution = (Solution) ois.readObject();
            for (Solution s : solution.edges){
                System.out.println("(" + s.nodeFrom + ")--->(" + s.nodeTo + ")");
            }
            fis.close(); ois.close();
        }catch (Exception ex){ex.printStackTrace();}
    }


    private int nodeFrom, nodeTo;

    Solution(){}

    Solution (int node1, int node2){
        this.nodeFrom = node1;
        this.nodeTo = node2;
    }
}
