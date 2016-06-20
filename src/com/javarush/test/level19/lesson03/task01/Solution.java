package com.javarush.test.level19.lesson03.task01;

/* TableAdapter
Измените класс TableAdapter так, чтобы он адаптировал ATable к BTable.
Метод getHeaderText должен возвращать такую строку "[username] : tablename".
Пример, "[Amigo] : DashboardTable"
*/

public class Solution {
    public static void main(String[] args) {
        //это пример вывода
        ATable aTable = new ATable() {
            @Override
            public String getCurrentUserName() {
                return "Amigo";
            }

            @Override
            public String getTableName() {
                return "DashboardTable";
            }
        };

        BTable table = new TableAdapter(aTable);
        System.out.println(table.getHeaderText());
    }

    public static class TableAdapter implements BTable{ // Adapter

        private ATable aTable;
        TableAdapter(ATable a){
            this.aTable = a;
        }
        public String getHeaderText()
        {
            return "[" + aTable.getCurrentUserName() + "] : " + aTable.getTableName();
        }
    }

    public interface ATable { // Adaptee
        String getCurrentUserName();
        String getTableName();
    }

    public interface BTable { // Target
        String getHeaderText();
    }
}