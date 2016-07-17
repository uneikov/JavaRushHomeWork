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

СОГЛАСНО ИНФОРМАЦИИ ИЗ ОБСУЖДЕНИЙ ФАЙЛ ДОБАВЛЯЕТСЯ В АРХИВ ЕСЛИ ОН УЖЕ ТАМ ЕСТЬ!!!
(Т.Е. СТАРЫЙ ЗАТИРАЕТСЯ, А НОВЫЙ ПИШЕТСЯ В ПАПКУ new/ )
*/

public class Solution {

    public static Map<ZipEntry, ByteArrayOutputStream> fileMap = new HashMap<>();

    public static void main(String[] args) throws IOException {

        File addToZipFile = new File(args[0]);
        File zipFile = new File(args[1]);

        if (!inflateOldZipContentToMap(zipFile, addToZipFile)) System.exit(0);
        addNewContentToMap(addToZipFile);
        writeNewZipContent(zipFile);

    }

    public static boolean inflateOldZipContentToMap(File zippedFile, File addToZipFile)
            throws IOException{

        ZipEntry zipEntry;
        String added = addToZipFile.getName();
        ZipFile zipFile = new ZipFile( zippedFile );
        boolean isFileExistInZipArchive = false;

        try (FileInputStream fis = new FileInputStream( zippedFile );
             ZipInputStream  zis = new ZipInputStream( fis )) {

            while ((zipEntry = zis.getNextEntry()) != null) {

                if (!zipEntry.getName().equals(added)) {
                    try(InputStream in = zipFile.getInputStream(zipEntry);
                        BufferedInputStream bis = new BufferedInputStream(in);
                        ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

                        byte[] buffer = new byte[bis.available()];
                        bis.read(buffer);
                        baos.write(buffer);

                        fileMap.put(zipEntry, baos);
                    }
                } else {
                    isFileExistInZipArchive = true;
                }
            }
        }

        return isFileExistInZipArchive;
    }


    public static void addNewContentToMap(File addToZipFile) throws IOException{

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(addToZipFile));
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[bis.available()];
            bis.read(buffer);
            baos.write(buffer);

            fileMap.put(new ZipEntry("new/".concat(addToZipFile.getName())), baos);
        }
    }

    public static void writeNewZipContent(File zipFile)throws IOException{

        try (FileOutputStream fos = new FileOutputStream(zipFile); ZipOutputStream zos = new ZipOutputStream(fos)) {

            for (Map.Entry<ZipEntry, ByteArrayOutputStream> map : fileMap.entrySet()) {
                zos.putNextEntry(map.getKey());
                zos.write(map.getValue().toByteArray());
                zos.closeEntry();
            }
        }
    }
}
