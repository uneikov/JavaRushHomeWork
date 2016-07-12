package com.javarush.test.level30.lesson15.big01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by URAN on 11.07.2016.
 */
public class Server {

    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    private static class Handler extends Thread{

        private Socket socket;

        public Handler(Socket socket){
            this.socket = socket;
        }

        public void run(){

            String userName = "";
            Connection connection = null;

            ConsoleHelper.writeMessage("Установлено новое соединение с удаленным адресом" +
                    socket.getRemoteSocketAddress());

            try {
                connection = new Connection(socket);
                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                sendListOfUsers(connection, userName);
                serverMainLoop(connection, userName);

            } catch (IOException | ClassNotFoundException ex){
                System.out.println("Произошла ошибка при обмене данными с удаленным адресом");
            }

            if (!userName.isEmpty()) {
                connectionMap.remove(userName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
            }

            try {
                connection.close();
            } catch (Exception exx) {
                exx.printStackTrace();
            }

            System.out.println("Cоединение с удаленным адресом закрыто");

        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException{

            Message message;
            String userName = "";

            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));

                message = connection.receive();

                if (message.getType().equals(MessageType.USER_NAME)) {
                    userName = message.getData();
                    if (!userName.isEmpty() && !connectionMap.containsKey(userName)) {
                        connectionMap.put(userName, connection);
                        connection.send(new Message(MessageType.NAME_ACCEPTED));
                        break;
                    }
                }
            }

            return userName;
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            for (Map.Entry<String, Connection> connectionEntry : connectionMap.entrySet()){
                if (!connectionEntry.getKey().equals(userName)) {
                    connection.send(new Message(MessageType.USER_ADDED, connectionEntry.getKey()));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {

            Message message;
            String text;

            while (true){
                message = connection.receive();
                if (message.getType().equals(MessageType.TEXT)){
                    text = userName + ": " + message.getData();
                    sendBroadcastMessage(new Message(MessageType.TEXT, text));
                }
                else {
                    System.out.println("Ошибка. Неверный тип сообщения");
                }
            }
        }
    }

    public static void sendBroadcastMessage(Message message){

        for (Map.Entry<String, Connection> connectionEntry : connectionMap.entrySet()){
            try {
                connectionEntry.getValue().send(message);
            }catch (IOException ex) {
                System.out.println("Сообщение не отправлено");
            }
        }
    }

    public static void main(String[] args) {

        ServerSocket serverSocket = null;
        Socket socket = null;

        int serverPort = ConsoleHelper.readInt();

        try {
            serverSocket = new ServerSocket(serverPort);
            ConsoleHelper.writeMessage("Сервер запущен");
            while (true){
                socket = serverSocket.accept();
                new Handler(socket).start();
            }
        }catch (IOException ex) {
            System.out.println("Ошибка сокета");
            try {
                serverSocket.close();
            } catch (Exception exx) {
                System.out.println("Ошибка сокета");
                exx.printStackTrace();
            }
        }
    }
}
