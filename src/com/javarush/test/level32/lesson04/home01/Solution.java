package com.javarush.test.level32.lesson04.home01;

import java.io.*;

/* Читаем из потока
Реализуйте логику метода getAllDataFromInputStream. Он должен вернуть StringWriter, содержащий все данные из переданного потока.
Возвращаемый объект ни при каких условиях не должен быть null.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {

        StringWriter sw = new StringWriter();
        char[] buf = new char[1024];
        int length;

        if (is != null) {
            InputStreamReader reader = new InputStreamReader(is);
            while ((length = reader.read(buf)) != -1) {
                sw.write(buf, 0, length);
            }
        }

        return sw;
    }
}
