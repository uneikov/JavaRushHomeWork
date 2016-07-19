package com.javarush.test.level31.lesson15.big01;

import com.javarush.test.level31.lesson15.big01.command.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by URAN on 19.07.2016.
 */
public class CommandExecutor {

    private CommandExecutor() {}

    private static final Map<Operation, Command> allKnownCommandsMap = new HashMap<>();

    static {
        allKnownCommandsMap.put(Operation.CREATE, new ZipCreateCommand());
        allKnownCommandsMap.put(Operation.ADD, new ZipAddCommand());
        allKnownCommandsMap.put(Operation.REMOVE, new ZipRemoveCommand());
        allKnownCommandsMap.put(Operation.EXTRACT, new ZipExtractCommand());
        allKnownCommandsMap.put(Operation.CONTENT, new ZipContentCommand());
        allKnownCommandsMap.put(Operation.EXIT, new ExitCommand());
    }

    public static void execute(Operation operation) throws Exception{
        allKnownCommandsMap.get(operation).execute();
    }
}
