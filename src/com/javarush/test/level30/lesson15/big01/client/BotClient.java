package com.javarush.test.level30.lesson15.big01.client;


import com.javarush.test.level30.lesson15.big01.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by URAN on 12.07.2016.
 */
public class BotClient extends Client {

    private static volatile Set<String> botNames = new HashSet<>();
    private static final String WELCOME_TEXT = "Привет чатику. Я бот. " +
            "Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.";

    public class BotSocketThread extends SocketThread {

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage(WELCOME_TEXT);
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {

            ConsoleHelper.writeMessage(message);
            String[] messageParts = message.split(": ");
            if (messageParts.length == 2) {
                String messageAuthor = messageParts[0];
                String messageText = messageParts[1].toLowerCase();
                String dateTimeformat = null;
                switch (messageText) {
                    case "дата":
                        dateTimeformat = "d.MM.YYYY";
                        break;
                    case "день":
                        dateTimeformat = "d";
                        break;
                    case "месяц":
                        dateTimeformat = "MMMM";
                        break;
                    case "год":
                        dateTimeformat = "YYYY";
                        break;
                    case "время":
                        dateTimeformat = "H:mm:ss";
                        break;
                    case "час":
                        dateTimeformat = "H";
                        break;
                    case "минуты":
                        dateTimeformat = "m";
                        break;
                    case "секунды":
                        dateTimeformat = "s";
                        break;
                }
                if (dateTimeformat != null) {
                    String reply = String.format("Информация для %s: %s",
                            messageAuthor,
                            new SimpleDateFormat(dateTimeformat).format(Calendar.getInstance().getTime())
                    );
                    sendTextMessage(reply);
                }
            }
        }
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
        String botName;
        if (botNames.size() >= 100) throw new RuntimeException("Число ботов превысило допустимый предел");
        do {
            botName = String.format("date_bot_%02d", new Random().nextInt(100));
        } while (botNames.contains(botName));
        botNames.add(botName);
        return botName;
    }

    public static void main(String[] args) {
        new BotClient().run();
    }
}
