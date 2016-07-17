package com.javarush.test.level31.lesson06.bonus01;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/* Разархивируем файл
В метод main приходит список аргументов.
Первый аргумент - имя результирующего файла resultFileName, остальные аргументы - имена файлов fileNamePart.
Каждый файл (fileNamePart) - это кусочек zip архива. Нужно разархивировать целый файл, собрав его из кусочков.
Записать разархивированный файл в resultFileName.
Архив внутри может содержать файл большой длины, например, 50Mb.
Внутри архива может содержаться файл с любым именем.

Пример входных данных. Внутри архива находится один файл с именем abc.mp3:
C:/result.mp3
C:/pathToTest/test.zip.003
C:/pathToTest/test.zip.001
C:/pathToTest/test.zip.004
C:/pathToTest/test.zip.002
*/
public class Solution {
    public static void main(String[] args) {

        String resultFileName = "C:/Users/URAN/Desktop/FileTest/BTO.txt";
        String multiPartZipDir  = "C:/MultipartZipArchive/";
        String[] multi  = { "C:/MultipartZipArchive/Documents.zip.001","C:/MultipartZipArchive/Documents.zip.002",
                            "C:/MultipartZipArchive/Documents.zip.003", "C:/MultipartZipArchive/Documents.zip.004",
                            "C:/MultipartZipArchive/Documents.zip.005", "C:/MultipartZipArchive/Documents.zip.006" };
        //String[] multi = {"C:/MultipartZipArchive/OOO/R.zip.001","C:/MultipartZipArchive/OOO/R.zip.002"};
        try (FileOutputStream fos = new FileOutputStream(resultFileName, true) ){

            for (int i = 0; i < multi.length; i++) {
                File file = new File(multi[i]);
                ZipFile zipFile = new ZipFile(file);
                try(
                        FileInputStream fis = new FileInputStream(file);
                        ZipInputStream zis = new ZipInputStream(fis);
                        InputStream in = zipFile.getInputStream(zis.getNextEntry());
                        BufferedInputStream bis = new BufferedInputStream(in)
                ) {

                    byte[] buffer = new byte[in.available()];
                    bis.read(buffer);
                    fos.write(buffer);
                    fos.flush();

                }catch (IOException ex) {ex.printStackTrace();}
            }

        }catch (IOException exx) {exx.printStackTrace();}





    }
}
