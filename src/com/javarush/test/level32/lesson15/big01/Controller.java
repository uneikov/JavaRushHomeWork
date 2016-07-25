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

    public void init(){

    }

    public void exit(){
        System.exit(0);
    }

    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();

    }
}
