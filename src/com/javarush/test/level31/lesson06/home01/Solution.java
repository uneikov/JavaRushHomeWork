package com.javarush.test.level31.lesson06.home01;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.zip.*;

/* Добавление файла в архив
В метод main приходит список аргументов.
Первый аргумент - полный путь к файлу fileName.
Второй аргумент - путь к zip-архиву.
Добавить файл (fileName) внутрь архива в директорию 'new'. ???
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

    public static void main(String[] args) throws IOException {

        File addToZipFile = new File(args[0]);
        File zipArchiveFile = new File(args[1]);

        processEverything(zipArchiveFile, addToZipFile);
    }

    public static void processEverything(File zippedFile, File addToZipFile) throws IOException{

        int length;
        final int BUFFER = 2_048;
        byte[] buffer = new byte[BUFFER];
        boolean inZip = false;
        Map<ZipEntry, byte[]> fileMap = new HashMap<>();
        String zippedFileName;
        String added = addToZipFile.getName();
        ZipFile zipFile = new ZipFile( zippedFile );

        Enumeration zipEntries = zipFile.entries();
        while (zipEntries.hasMoreElements()) {
            ZipEntry zipEntry = (ZipEntry) zipEntries.nextElement();
            zippedFileName = Paths.get(zipEntry.getName()).getFileName().toString();
            if (zippedFileName.equals(added)) {
                  inZip = true;
            }
        }
        if (!inZip) return;

        try (ZipInputStream  zis = new ZipInputStream(Files.newInputStream(zippedFile.toPath()))) {

            ZipEntry zipEntry = zis.getNextEntry();
            while (zipEntry != null) {

                zippedFileName = Paths.get(zipEntry.getName()).getFileName().toString();

                if (!zippedFileName.equals(added)) {
                    try(BufferedInputStream bis = new BufferedInputStream(zipFile.getInputStream(zipEntry));
                        ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

                        while ((length = bis.read(buffer,0, BUFFER)) > 0){
                            baos.write(buffer, 0, length);
                        }

                        fileMap.put(zipEntry, baos.toByteArray());
                    }
                } else {
                    try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(addToZipFile));
                         ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

                        while ((length = bis.read(buffer,0, BUFFER)) > 0){
                            baos.write(buffer, 0, length);
                        }

                        fileMap.put(new ZipEntry(zipEntry.getName()), baos.toByteArray());
                    }
                }
                zipEntry = zis.getNextEntry();
            }
        }

        try (ZipOutputStream zos = new ZipOutputStream(Files.newOutputStream(zippedFile.toPath()))) {

            for (Map.Entry<ZipEntry, byte[]> map : fileMap.entrySet()) {
                zos.putNextEntry(map.getKey());
                zos.write(map.getValue());
                zos.closeEntry();
            }
        }
    }
}
