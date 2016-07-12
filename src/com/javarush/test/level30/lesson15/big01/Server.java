package com.javarush.test.level30.lesson15.big01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by URAN on 11.07.2016.
 */
public class Server {

    private static class Handler extends Thread{

        private Socket socket;

        public Handler(Socket socket){
            this.socket = socket;
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
