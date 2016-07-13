package com.javarush.test.level31.lesson02.home01;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* Проход по дереву файлов
1. На вход метода main подаются два параметра.
Первый - path - путь к директории, второй - resultFileAbsolutePath - имя файла, который будет содержать результат.
2. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
2.1. Если у файла длина в байтах больше 50, то удалить его.
2.2. Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
2.2.1. отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке
2.2.2. переименовать resultFileAbsolutePath в 'allFilesContent.txt'
2.2.3. в allFilesContent.txt последовательно записать содержимое всех файлов из п. 2.2.1. Тела файлов разделять "\n"
2.3. Удалить директории без файлов (пустые).
Все файлы имеют расширение txt.
*/
public class Solution {

    public static List<File> fileList = new ArrayList<>();

    public static void main(String[] args) {

        //String path = args[0]; // путь к директории
        String path = "C:/Users/Uran/Desktop/FileTest/";
        //String resultFileAbsolutePath = args[1]; // файл куда пишем результат
        String resultFileAbsolutePath = "C:/Users/Uran/Desktop/resultFileAbsolutePath.txt";
        File result = new File(resultFileAbsolutePath);

        FileWriter fileWriter = null;
        File folder = new File(path);

        processFiles(folder);
        deleteEmptyDirectories(folder);
        sortFiles();

        try  {
            fileWriter = new FileWriter(resultFileAbsolutePath, true);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        result.renameTo(new File(resultFileAbsolutePath.replace(result.getName(),"allFilesContent.txt")));

        for (File file : fileList) {
            try (FileReader fileReader = new FileReader(file)) {
                char[] buf = new char[(int) file.length() + 1];
                fileReader.read(buf);
                buf[buf.length - 1] = '\n';
                fileWriter.write(buf);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        try {
            fileWriter.flush();
            fileWriter.close();
        }catch (IOException exx) {}

        for (File file : fileList) {
            System.out.println(file.toString());
        }

    }

    public static void processFiles(File folder){
        for (File file : folder.listFiles()){
            if (file.isFile()) {
                if(file.length() > 50) file.delete();
                else fileList.add(file);
            }else {
                if (file.isDirectory()) processFiles(file);
            }
        }
    }

    public static void deleteEmptyDirectories(File folder){
        for (File file : folder.listFiles()){
            if (file.isDirectory()) {
                deleteEmptyDirectories(file);
                file.delete();
            }
        }
    }

    public static void sortFiles(){
        Collections.sort(fileList, new Comparator<File>() {
            @Override
            public int compare(File file1, File file2) {
                return file1.getName().compareTo(file2.getName());
            }
        });
    }
}
