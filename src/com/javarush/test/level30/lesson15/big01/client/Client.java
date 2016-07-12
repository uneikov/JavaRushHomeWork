package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.Connection;

/**
 * Created by URAN on 12.07.2016.
 */
public class Client {

    protected Connection connection;
    volatile private boolean clientConnected = false;

    public class SocketThread extends Thread {

    }
}
