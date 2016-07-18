package com.javarush.test.level31.lesson15.big01;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by URAN on 18.07.2016.
 */
public class ZipFileManager {

    private Path zipFile;

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }

    public void createZip(Path source) throws Exception{

        try(ZipOutputStream zos = new ZipOutputStream(Files.newOutputStream(zipFile))){

            ZipEntry zipEntry = new ZipEntry(source.toFile().getName());
            zos.putNextEntry(zipEntry);

            try(BufferedInputStream bis = new BufferedInputStream(Files.newInputStream(source))){
                byte[] buffer = new byte[bis.available()];
                bis.read(buffer);
                zos.write(buffer);
            }
            zos.closeEntry();
        }
    }
}
