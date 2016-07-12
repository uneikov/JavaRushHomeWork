package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.Connection;
import com.javarush.test.level30.lesson15.big01.ConsoleHelper;
import com.javarush.test.level30.lesson15.big01.Message;
import com.javarush.test.level30.lesson15.big01.MessageType;

import java.io.IOException;

/**
 * Created by URAN on 12.07.2016.
 */
public class Client {

    protected Connection connection;
    volatile private boolean clientConnected = false;

    public class SocketThread extends Thread {

    }

    public void run(){
        String in;
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();

        try {
            synchronized (this) {
                this.wait();
            }
        } catch (InterruptedException ex) {
            ConsoleHelper.writeMessage("Соединение прервано");
            return;
        }

        if (clientConnected)
            ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
        else
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");

        while (clientConnected){
            in = ConsoleHelper.readString();
            if (in.equals("exit".toLowerCase())) break;
            else if (shouldSentTextFromConsole()) sendTextMessage(in);
        }
    }

    protected String getServerAddress(){
        ConsoleHelper.writeMessage("Введите адрес сервера:");
        return ConsoleHelper.readString();
    }

    protected int getServerPort(){
        ConsoleHelper.writeMessage("Введите порт сервера:");
        return ConsoleHelper.readInt();
    }

    protected String getUserName(){
        ConsoleHelper.writeMessage("Введите имя пользователя:");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSentTextFromConsole(){
        return true;
    }

    protected SocketThread getSocketThread(){
        return new SocketThread();
    }

    protected void sendTextMessage(String text){
        try {
            connection.send(new Message(MessageType.TEXT, text));
        }catch (IOException exx){
            System.out.println("Ошибка соединения. Сообщение отослать не удалось");
            clientConnected = false;
        }
    }

    public static void main(String[] args) {
        new Client().run();
    }
}
