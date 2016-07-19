package com.javarush.test.level31.lesson15.big01;


import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Created by URAN on 19.07.2016.
 */
public class FileManager {

    private Path rootPath;
    private List<Path> fileList;

    public FileManager(Path rootPath) throws IOException{
        this.rootPath = rootPath;
        collectFileList(rootPath);
    }

    public List<Path> getFileList() {
        return fileList;
    }

    private void collectFileList(Path path) throws IOException{
        if (Files.isRegularFile(path)){
            fileList.add(path.relativize(rootPath));
            /*
            Проверить, если переданный путь path является обычным файлом (используй метод
            Files.isRegularFile), то получить его относительный путь относительно rootPath
            и добавить его в список fileList.
             */
        }else {
            if (Files.isDirectory(path)){
                DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path);
                for (Path pathToDir: directoryStream){
                    collectFileList(pathToDir);
                }
                /*
                Если переданный путь path, является директорией (узнать это поможет метод
                Files.isDirectory), то пройтись по всему содержимому директории и вызвать
                collectFileList(Path path), передав в path обнаруженные элементы.
                Пройтись по всему содержимому директории можно предварительно получив DirectoryStream с помощью метода
                newDirectoryStream класса Files. Не забудь закрыть созданный DirectoryStream.
                 */
            }
        }
    }
}
