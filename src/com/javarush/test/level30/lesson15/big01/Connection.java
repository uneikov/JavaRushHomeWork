package com.javarush.test.level30.lesson15.big01;

import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Created by URAN on 11.07.2016.
 */
public class Connection implements Closeable{
    private final Socket socket;
    private final ObjectOutputStream out;
    private final ObjectInputStream in;

    public Connection(Socket socket) throws IOException{
        this.socket = socket;
        this.out = new ObjectOutputStream(socket.getOutputStream());
        this.in = new ObjectInputStream(socket.getInputStream());
    }

    public void send(Message message) throws IOException{



        /*
        Он должен записывать
(сериализовать) сообщение message в ObjectOutputStream. Этот метод будет
вызываться из нескольких потоков. Позаботься, чтобы запись в объект
ObjectOutputStream была возможна только одним потоком в определенный момент
времени, остальные желающие ждали завершения записи. При этом другие методы
класса Connection не должны быть заблокированы.
         */
    }

    public Message receive() throws IOException, ClassNotFoundException{
        /*
        Он должен читать
(десериализовать) данные из ObjectInputStream. Сделай так, чтобы операция чтения
не могла быть одновременно вызвана несколькими потоками, при этом вызов других
методы класса Connection не блокировать.
         */
        return null;
    }

    public SocketAddress getRemoteSocketAddress(){
        return socket.getRemoteSocketAddress();
    }

    public void close() throws IOException {
        in.close();
        out.close();
        socket.close();
    }
}
