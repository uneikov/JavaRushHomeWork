package com.javarush.test.level22.lesson13.task02;

import java.io.*;
import java.nio.charset.Charset;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {

        if (args[0] == null || args[1] == null)
        {
            System.out.println(" Wrong parameters!");
            System.exit(-1);
        }

        String fileWIN = args[0];
        String fileUTF = args[1];
        Charset utf8 = Charset.forName("UTF-8");
        Charset win1251 = Charset.forName("Windows-1251");
        String next;

        try ( BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileWIN), utf8));
              BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileUTF), utf8)))
        {
            while ((next = reader.readLine()) != null) writer.write(new String(next.getBytes(win1251),utf8));
        }

    }
}
