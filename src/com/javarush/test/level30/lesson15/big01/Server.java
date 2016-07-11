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
        ServerSocket serverSocket;
        int port = ConsoleHelper.readInt();
        try {
            serverSocket = new ServerSocket(port);
        }catch (IOException ex) {}
        ConsoleHelper.writeMessage("Сервер запущен");
        while (true){

        }
    }
}
