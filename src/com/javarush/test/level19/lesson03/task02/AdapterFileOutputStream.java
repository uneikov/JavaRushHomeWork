package com.javarush.test.level19.lesson03.task02;

/* Адаптер
Используйте класс AdapterFileOutputStream, чтобы адаптировать FileOutputStream к новому интерфейсу AmigoStringWriter
FileOutputStream = Adaptee
*/

import java.io.FileOutputStream;
import java.io.IOException;

public class AdapterFileOutputStream implements AmigoStringWriter{ // Adapter implements Target

    private FileOutputStream stream;

    AdapterFileOutputStream(FileOutputStream s){
        this.stream = s;
    }

    public void flush() throws IOException {
        stream.flush();
    }

    public void writeString(String s) throws IOException
    {
        stream.write(s.getBytes());
    }

    public void close() throws IOException {
        stream.close();

    }
}

