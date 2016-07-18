package com.javarush.test.level31.lesson15.big01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Paths;

/**
 * Created by URAN on 18.07.2016.
 */

public class Archiver {
    public static void main(String[] args) {

        String fileName;

        try (BufferedReader r = new BufferedReader(new InputStreamReader(System.in))){

            System.out.println("Input full path to file for result archive:");
            fileName = r.readLine();
            ZipFileManager manager = new ZipFileManager(Paths.get(fileName));
            System.out.println("Input full path to file you want to be archived:");
            fileName  = r.readLine();
            manager.createZip(Paths.get(fileName));

        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
