package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {

        byte key = (byte) 0b10101010;
        if (args.length == 0){System.out.println("Invalid args");
            System.exit(0);}
        if (args[0].equals("-e") ){
            byte[] encodedArray = cipherFile(args[1], key);
            saveFile(args[2], encodedArray);
        }else if(args[0].equals("-d")){
            byte[] decodedArray = cipherFile(args[1], key);
            saveFile(args[2], decodedArray);
        }else {
            System.out.println("Error in parameter string");
            System.exit(0);
        }
    }
    public static void saveFile(String name, byte[] outfile) throws IOException{
        FileOutputStream out = new FileOutputStream(name);
        out.write(outfile);
    }

    public static byte[] cipherFile(String name, byte key) throws IOException{
        FileInputStream in = new FileInputStream(name);
        int size = in.available();
        byte[] inarr = new byte[size];
        byte[] outarr = new byte[size];
        if (size > 0){
            in.read(inarr);
            outarr = cipherXOR(inarr, key);
        }
        return outarr;
    }

    public static byte[]  cipherXOR(byte[] byteArray, byte key){
        byte[] cipherArray = new byte[byteArray.length];
        for( int i = 0; i < byteArray.length; i++){
            cipherArray[i] = (byte)( key ^ byteArray[i]);
        }
        return cipherArray;
    }
}
