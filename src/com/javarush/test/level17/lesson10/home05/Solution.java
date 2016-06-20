package com.javarush.test.level17.lesson10.home05;

/* Лишняя синхронизация
synchronized существенно замедляет программу, поэтому убери избыточность synchronized внутри методов
*/

public class Solution {
    char[] value;
    int count;

    public Solution append(CharSequence s) {// убрали всю синхронизацию по логике работы метода

            if (s == null) {
                    s = "null";
            }

            if (s instanceof String) {
                    return this.append((String) s);
            }

            if (s instanceof Solution) {
                    return this.appendThis((Solution) s);
            }

        return this.append(s);
    }

    public synchronized Solution appendThis(Solution s) {
        //do something here....
        return this;
    }

    private static final java.io.ObjectStreamField[] serialPersistentFields =
            {
                    new java.io.ObjectStreamField("value", char[].class),
                    new java.io.ObjectStreamField("count", Integer.TYPE),
                    new java.io.ObjectStreamField("shared", Boolean.TYPE),
            };
    // убрали синхронизацию внутри метода
    private synchronized void writeObject(java.io.ObjectOutputStream s) throws java.io.IOException {
        java.io.ObjectOutputStream.PutField fields = s.putFields();

            fields.put("value", value);
            fields.put("count", count);
            fields.put("shared", false);

            s.writeFields();

    }
    // убрали синхронизацию внутри метода и вообще - ничего не пишет, только читает
    private void readObject(java.io.ObjectInputStream s) throws java.io.IOException, ClassNotFoundException {

            java.io.ObjectInputStream.GetField fields = s.readFields();
            value = (char[]) fields.get("value", null);
            count = fields.get("count", 0);

    }
}
