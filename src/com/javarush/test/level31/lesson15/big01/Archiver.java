package com.javarush.test.level31.lesson15.big01;

import com.javarush.test.level31.lesson15.big01.exception.WrongZipFileException;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


/**
 * Created by URAN on 18.07.2016.
 */

public class Archiver {

    public static void main(String[] args) {

        Operation operation = null;
        do {
            try {
                operation = askOperation();
                FileManager fm = new FileManager(Paths.get("C:/Users/URAN/Desktop/FileTest"));
                List<Path> list = fm.getFileList();
                CommandExecutor.execute(operation);
            } catch (WrongZipFileException e) {
                ConsoleHelper.writeMessage("Вы не выбрали файл архива или выбрали неверный файл.");
            } catch (Exception e) {
                e.printStackTrace();
                ConsoleHelper.writeMessage("Произошла ошибка. Проверьте введенные данные.");
            }

        } while (operation != Operation.EXIT);
    }

    public static Operation askOperation() throws IOException {
         final String ASK_OPERATION =
                "Выберите операцию:" +
                        "\n%d - упаковать файлы в архив" +
                        "\n%d - добавить файл в архив" +
                        "\n%d - удалить файл из архива" +
                        "\n%d - распаковать архив" +
                        "\n%d - просмотреть содержимое архива" +
                        "\n%d – выход";

        String ask = String.format(ASK_OPERATION,
                Operation.CREATE.ordinal(),
                Operation.ADD.ordinal(),
                Operation.REMOVE.ordinal(),
                Operation.EXTRACT.ordinal(),
                Operation.CONTENT.ordinal(),
                Operation.EXIT.ordinal()
        );
        ConsoleHelper.writeMessage(ask);
        int operationIndex = ConsoleHelper.readInt();

        return Operation.values()[operationIndex];
    }
}
