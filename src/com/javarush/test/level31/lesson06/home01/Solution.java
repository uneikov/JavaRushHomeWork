package com.javarush.test.level31.lesson06.home01;

import java.io.*;
import java.util.*;
import java.util.zip.*;

/* Добавление файла в архив
В метод main приходит список аргументов.
Первый аргумент - полный путь к файлу fileName.
Второй аргумент - путь к zip-архиву.
Добавить файл (fileName) внутрь архива в директорию 'new'.
Если в архиве есть файл с таким именем, то заменить его.

Пример входных данных:
C:/result.mp3
C:/pathToTest/test.zip

Файлы внутри test.zip:
a.txt
b.txt

После запуска Solution.main архив test.zip должен иметь такое содержимое:
new/result.mp3
a.txt
b.txt

Подсказка: нужно сначала куда-то сохранить содержимое всех энтри,
а потом записать в архив все энтри вместе с добавленным файлом.
Пользоваться файловой системой нельзя.
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        Map<String, ByteArrayOutputStream> fileMap;
        String zipFileName = "C:/Users/URAN/Desktop/FileTest/wr.zip";
        String addToZipFileName = "C:/Users/URAN/Desktop/FileTest/alaniaheits.txt";

        fileMap = inflateOldZipContentToMap(zipFileName);
        addNewContentToMap(addToZipFileName, fileMap);
        writeNewZipContent(zipFileName, fileMap);

    }

    public static Map<String, ByteArrayOutputStream> inflateOldZipContentToMap(String zipFileName) throws IOException{
        ZipEntry zipEntry;
        int inline;
        FileInputStream zipInFile = new FileInputStream(zipFileName);
        ZipInputStream  zipIn = new ZipInputStream(zipInFile);
        ByteArrayOutputStream baos;
        BufferedReader reader;
        Map<String, ByteArrayOutputStream> fileMap = new HashMap<>();

        ZipFile zipFile = new ZipFile( zipFileName );

        while ((zipEntry = zipIn.getNextEntry()) != null){

            InputStream in = zipFile.getInputStream(zipEntry);
            baos = new ByteArrayOutputStream();
            reader = new BufferedReader(new InputStreamReader(in));

            while ((inline = reader.read()) != -1) {
                baos.write(inline);
            }

            fileMap.put(zipEntry.getName(), baos);

        }

        return fileMap;
    }


    public static   Map<String, ByteArrayOutputStream> addNewContentToMap(String addToZipFileName, Map<String, ByteArrayOutputStream> fileMap)
    throws IOException{
        int inline;
        File file = new File(addToZipFileName);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        while ((inline = reader.read()) != -1) {
            baos.write(inline);
        }

        fileMap.put("new/alaniaheits.txt", baos);
        baos.close();

        return fileMap;
    }

    public static void writeNewZipContent(String zipFileName, Map<String, ByteArrayOutputStream> fileMap)throws IOException{

        FileOutputStream zipOutFile = new FileOutputStream(zipFileName);
        ZipOutputStream zipOut = new ZipOutputStream(zipOutFile);
        zipOut.setLevel(Deflater.DEFAULT_COMPRESSION);

        for (Map.Entry<String, ByteArrayOutputStream> map: fileMap.entrySet()){
            String fileName = map.getKey();
            zipOut.putNextEntry(new ZipEntry(fileName));
            map.getValue().writeTo(zipOut);
        }

        zipOut.close();
    }
}
