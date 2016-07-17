package com.javarush.test.level31.lesson06.bonus01;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
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

        String resultFileName = "C:/Users/URAN/Desktop/FileTest/LZ.mp3";
        String multiPartZipDir  = "C:/MultipartZipArchive/";
        String[] multi  = { "C:/MultipartZipArchive/Since I've Been Loving You.zip.001", "C:/MultipartZipArchive/Since I've Been Loving You.zip.002",
                            "C:/MultipartZipArchive/Since I've Been Loving You.zip.003", "C:/MultipartZipArchive/Since I've Been Loving You.zip.004",
                            "C:/MultipartZipArchive/Since I've Been Loving You.zip.005", "C:/MultipartZipArchive/Since I've Been Loving You.zip.006" };
        //String[] multi = {"C:/MultipartZipArchive/OOO/R.zip.001","C:/MultipartZipArchive/OOO/R.zip.002"};
        Path tempFilePath = null;
        try {
            tempFilePath = Files.createTempFile("temp", ".zip");
            FileOutputStream fos = new FileOutputStream(tempFilePath.toFile(), true);
            for (int i = 0; i < multi.length; i++) {
                try(FileInputStream fis = new FileInputStream(multi[i]);
                BufferedInputStream bis = new BufferedInputStream(fis)){
                    byte[] buffer = new byte[bis.available()];
                    bis.read(buffer);
                    fos.write(buffer);
                    fos.flush();
                }
            }
        }catch (IOException ex) {ex.printStackTrace();}

        try (FileOutputStream fos = new FileOutputStream(resultFileName) ){

                File file = tempFilePath.toFile();
                ZipFile zipFile = new ZipFile(file);
                try(
                        InputStream inn = Files.newInputStream(tempFilePath, StandardOpenOption.READ);
                        //FileInputStream fis = new FileInputStream(file);
                        ZipInputStream zis = new ZipInputStream(inn);
                        InputStream in = zipFile.getInputStream(zis.getNextEntry());
                        BufferedInputStream bis = new BufferedInputStream(in)
                ) {

                    byte[] buffer = new byte[in.available()];
                    bis.read(buffer);
                    fos.write(buffer);
                    fos.flush();

                }catch (IOException ex) {ex.printStackTrace();}


        }catch (IOException exx) {exx.printStackTrace();}

    }
}
