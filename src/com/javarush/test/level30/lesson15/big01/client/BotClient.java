package com.javarush.test.level30.lesson15.big01.client;

/**
 * Created by URAN on 12.07.2016.
 */
public class BotClient extends Client {

    public class BotSocketThread extends SocketThread {

    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSentTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        return "date_bot_" + (int)Math.ceil(Math.random()*100);
    }

    public static void main(String[] args) {
        new BotClient().run();
    }
}
