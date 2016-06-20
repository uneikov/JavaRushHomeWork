package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

/**
 * Created by URAN on 30.03.2016.
 */
public class ImageReaderFactory // через switch не проходит, через equals непроходит
{
    public static ImageReader getReader(ImageTypes type)
    {
        if (type == ImageTypes.JPG) {
            return new JpgReader();
        } else if (type == ImageTypes.PNG) {
            return new PngReader();
        } else if (type == ImageTypes.BMP){
            return new BmpReader();
        } else {
            throw new IllegalArgumentException("Неизвестный тип");
        }
    }
}
