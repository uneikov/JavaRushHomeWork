package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.Connection;
import com.javarush.test.level30.lesson15.big01.ConsoleHelper;
import com.javarush.test.level30.lesson15.big01.Message;
import com.javarush.test.level30.lesson15.big01.MessageType;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by URAN on 12.07.2016.
 */
public class Client {

    protected Connection connection;
    volatile private boolean clientConnected = false;

    public class SocketThread extends Thread {

        public void run(){
            try {
                Socket socket = new Socket(getServerAddress(), getServerPort());
                Client.this.connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();
            }catch (IOException | ClassNotFoundException ex){
                notifyConnectionStatusChanged(false);
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException{
            Message message;
            while (true){
                message = connection.receive();
                switch (message.getType()){
                    case NAME_REQUEST: connection.send(new Message(MessageType.USER_NAME, getUserName())); break;
                    case NAME_ACCEPTED: notifyConnectionStatusChanged(true); return;
                    default: throw new IOException("Unexpected MessageType");
                }
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            Message message;
            while (true){
                message = connection.receive();
                switch (message.getType()){
                    case TEXT: processIncomingMessage(message.getData()); break;
                    case USER_ADDED: informAboutAddingNewUser(message.getData()); break;
                    case USER_REMOVED: informAboutDeletingNewUser(message.getData()); break;
                    default: throw new IOException("Unexpected MessageType");
                }
            }
        }

        protected void processIncomingMessage(String message){
           ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName){
            ConsoleHelper.writeMessage(String.format("Участник с именем %s присоединился к чату", userName));
        }

        protected void informAboutDeletingNewUser(String userName){
            ConsoleHelper.writeMessage(String.format("Участник с именем %s покинул чат", userName));
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected){
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this) {
                Client.this.notify();
            }
        }
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
