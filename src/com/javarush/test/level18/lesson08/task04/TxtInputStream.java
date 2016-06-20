package com.javarush.test.level18.lesson08.task04;

import java.io.*;

/* UnsupportedFileName
Измените класс TxtInputStream так, чтобы он работал только с txt-файлами (*.txt)
Например, first.txt или name.1.part3.txt
Если передан не txt-файл, например, file.txt.exe, то конструктор должен выбрасывать исключение UnsupportedFileNameException
*/

public class TxtInputStream extends FileInputStream {

    public TxtInputStream(String fileName) throws FileNotFoundException, UnsupportedFileNameException {
        super(fileName);
        if (!".txt".equals(fileName.substring(fileName.length()-4,fileName.length()))) throw new UnsupportedFileNameException();
    }

    public TxtInputStream(File file) throws FileNotFoundException, IOException, UnsupportedFileNameException {
        super(file);
        String path = file.getCanonicalPath();
        if (!".txt".equals(path.substring(path.length()-4,path.length()))) throw new UnsupportedFileNameException();
    }

    public TxtInputStream(FileDescriptor fdObj) {
        super(fdObj);
    }

}

