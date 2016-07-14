package com.javarush.test.level31.lesson02.home02;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/* Находим все файлы
Реализовать логику метода getFileTree, который должен в директории root найти список всех файлов включая вложенные.
Используйте очередь, рекурсию не используйте.
Верните список всех путей к найденным файлам, путь к директориям возвращать не надо.
Путь должен быть абсолютный.
*/
public class Solution {
/*
    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        String rootDirectory = "C:/Users/URAN/Desktop/FileTest/";

        try {
            result = getFileTree(rootDirectory);
        }catch (IOException ex){
            ex.printStackTrace();
        }
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
*/
    public static List<String> getFileTree(String root) throws IOException{
        Queue<File> queue = new ArrayDeque<>();
        List<String> files = new ArrayList<>();
        File workingDirectory;
        queue.add(new File(root));

        while (!queue.isEmpty()){
            workingDirectory = queue.poll();
            for (File file : workingDirectory.listFiles()){
                if (file.isDirectory()) queue.add(file);
                else files.add(file.getAbsolutePath());
            }
        }

        return files;
    }
}
