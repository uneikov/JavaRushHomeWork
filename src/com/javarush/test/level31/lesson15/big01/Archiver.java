package com.javarush.test.level31.lesson15.big01;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * Created by URAN on 18.07.2016.
 */

public class Archiver {
    public static void main(String[] args) {

        String fileName;

        while (true) {

            ConsoleHelper.writeMessage("Input full path to file for result archive:");

            fileName = ConsoleHelper.readString();
            ZipFileManager manager = new ZipFileManager(Paths.get(fileName));

            ConsoleHelper.writeMessage("Input full path to file you want to be archived:");
            fileName = ConsoleHelper.readString();

            try {
                manager.createZip(Paths.get(fileName));
                break;
            }catch (Exception ex){
                ConsoleHelper.writeMessage("Invalid input. Try one`s more");
            }
        }
    }
}
