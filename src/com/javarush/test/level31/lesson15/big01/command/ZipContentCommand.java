package com.javarush.test.level31.lesson15.big01.command;

import com.javarush.test.level31.lesson15.big01.FileProperties;
import com.javarush.test.level31.lesson15.big01.ZipFileManager;

import java.nio.file.Paths;
import java.util.List;

/**
 * Created by URAN on 19.07.2016.
 */
public class ZipContentCommand extends ZipCommand{
    @Override
    public void execute() throws Exception {

        //List<FileProperties> list = new ZipFileManager(Paths.get("C:/Users/URAN/DEsktop/ZZZ/zzz.zip")).getFilesList();
        //for (FileProperties props : list) System.out.println(props.toString());
    }
}
