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
        //String addToZipFileName = args[0];
        //String zipFileName = args[1];
        String zipFileName = "C:/Users/URAN/Desktop/FileTest/wr.zip";
        String addToZipFileName = "C:/Users/URAN/Desktop/FileTest/alaniaheits.txt";

        fileMap = inflateOldZipContentToMap(zipFileName, addToZipFileName);
        addNewContentToMap(addToZipFileName, fileMap);
        writeNewZipContent(zipFileName, fileMap);

    }

    public static Map<String, ByteArrayOutputStream> inflateOldZipContentToMap(String zipFileName, String addToZipFileName)
            throws IOException{

        ZipEntry zipEntry;
        ZipFile zipFile = new ZipFile( zipFileName );
        FileInputStream fis = new FileInputStream(zipFileName);
        ZipInputStream  zis = new ZipInputStream(fis);
        ByteArrayOutputStream baos;
        Map<String, ByteArrayOutputStream> fileMap = new HashMap<>();

        while ((zipEntry = zis.getNextEntry()) != null){
            if (!zipEntry.getName().equals(new File(addToZipFileName).getName())){
                InputStream in = zipFile.getInputStream(zipEntry);
                BufferedInputStream bis = new BufferedInputStream(in);
                baos = new ByteArrayOutputStream();
                while (bis.available() != 0) baos.write(bis.read());
                fileMap.put(zipEntry.getName(), baos);
            }
        }

        return fileMap;
    }


    public static  void addNewContentToMap(String addToZipFileName, Map<String, ByteArrayOutputStream> fileMap) throws IOException{

        File file = new File(addToZipFileName);
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        while (bis.available() != 0) baos.write(bis.read());

        fileMap.put("new/alaniaheits.txt", baos);

        bis.close();
        baos.close();

        //return fileMap;
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
