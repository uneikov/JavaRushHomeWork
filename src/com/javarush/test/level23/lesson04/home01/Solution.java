package com.javarush.test.level23.lesson04.home01;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* Inner 3
Внутри класса Solution:
1) реализуйте private class TaskDataProvider используя Task и DbMock, цель которого - обновить поле tasks.
2) реализуйте private class NameDataProvider используя String и DbMock, цель которого - обновить поле names.
*/
public class Solution {

    public static void main(String[] args){
        Solution sol = new Solution();
        sol.refresh();
    }

    private List<Task> tasks; // эти переменные не инициализированы!!!
    private List<String> names;

    private DbDataProvider taskDataProvider = new TaskDataProvider();
    private DbDataProvider nameDataProvider = new NameDataProvider();

    public void refresh() {
        Map taskCriteria = ViewMock.getFakeTasksCriteria();
        taskDataProvider.refreshAllData(taskCriteria);

        Map nameCriteria = ViewMock.getFakeNamesCriteria();
        nameDataProvider.refreshAllData(nameCriteria);
    }

    private interface DbDataProvider<T> {
        void refreshAllData(Map criteria);
    }

    private class TaskDataProvider implements DbDataProvider{

        @Override  // инициализация tasks
        public void refreshAllData(Map criteria)
        {
            List<Task> temp = DbMock.getFakeTasks(criteria);
            if (temp != null)
                tasks = new LinkedList<>(temp);
        }
    }
    private class NameDataProvider implements DbDataProvider{

        @Override  // инициализация names
        public void refreshAllData(Map criteria)
        {
            List<String> temp = DbMock.getFakeNames(criteria);
            if (temp != null)
            names = new LinkedList<>(temp);

        }
    }
    class Task {
    }
}
