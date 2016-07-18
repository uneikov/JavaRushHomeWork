package com.javarush.test.level31.lesson10.home01;


import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/* Читаем конфиги
Реализовать метод getProperties, который должен считывать свойства из переданного файла fileName.
fileName может иметь любое расширение - как xml, так и любое другое, или вообще не иметь.
Нужно обеспечить корректное чтение свойств.
При возникновении ошибок должен возвращаться пустой объект.
Метод main не участвует в тестировании.
Подсказка: возможно, Вам понадобится File.separator.
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("src/com/javarush/test/level31/lesson10/home01/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("src/com/javarush/test/level31/lesson10/home01/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("src/com/javarush/test/level31/lesson10/home01/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {

        Path path = null;
        InputStream in = null;
        Properties properties = new Properties();
        boolean loadFromXmlSuccessfully;
        fileName = fileName.replaceAll("\\\\", File.separator);

        try {
            // xml файл может не иметь расширения...
            path = Paths.get(fileName).toAbsolutePath();
            in = Files.newInputStream(path);
            properties.loadFromXML(in);
            loadFromXmlSuccessfully = true;

        }catch (Exception ex){

            loadFromXmlSuccessfully = false;
        }

        if (!loadFromXmlSuccessfully){
            try {

                path = Paths.get(fileName).toAbsolutePath();
                in = Files.newInputStream(path);
                properties.load(in);

            }catch (Exception ex){

                return  properties;
            }finally {
                try {
                    in.close();
                }catch (Exception ex) {}
            }
        }
        return properties;
    }
}
