package com.javarush.test.level32.lesson15.big01;

import javax.swing.text.html.HTMLDocument;
import java.io.File;

/**
 * Created by URAN on 25.07.2016.
 */
public class Controller {

    private View view;
    private HTMLDocument document;
    private File currentFile;
    private Controller controller;

    public Controller(View view) {
        this.view = view;
    }

}
