package com.javarush.test.level31.lesson08.home01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/* Null Object Pattern
Почитайте на вики про паттерн "Null Object"
Используйте Files, чтобы в конструкторе класса Solution правильно инициализировать поле fileData объектом ConcreteFileData.
Если возникли какие-то проблемы со чтением файла по пути pathToFile, то инициализируйте поле объектом NullFileData.
*/
public class Solution {
    private FileData fileData;

    public Solution(String pathToFile) {
        Path path = Paths.get(pathToFile);
        try {
            boolean hidden = Files.isHidden(path);
            boolean executable = Files.isExecutable(path);
            boolean directory = Files.isDirectory(path);
            boolean writable = Files.isWritable(path);
            this.fileData = new ConcreteFileData(
                    hidden,
                    executable,
                    directory,
                    writable
            );
        }catch (IOException ex) {
            this.fileData = new NullFileData(ex);
        }
    }

    public FileData getFileData() {
        return fileData;
    }
}
