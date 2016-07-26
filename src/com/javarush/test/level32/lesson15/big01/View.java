package com.javarush.test.level32.lesson15.big01;

import com.javarush.test.level32.lesson15.big01.listeners.FrameListener;
import com.javarush.test.level32.lesson15.big01.listeners.TabbedPaneChangeListener;
import com.javarush.test.level32.lesson15.big01.listeners.UndoListener;

import javax.swing.*;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by URAN on 25.07.2016.
 */
public class View extends JFrame implements ActionListener {

    private Controller controller;
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();
    private UndoManager undoManager = new UndoManager();
    private UndoListener undoListener = new UndoListener(undoManager);

    public View(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (UnsupportedLookAndFeelException e) {
            ExceptionHandler.log(e);
        }
        catch (ClassNotFoundException e) {
            ExceptionHandler.log(e);
        }
        catch (InstantiationException e) {
            ExceptionHandler.log(e);
        }
        catch (IllegalAccessException e) {
            ExceptionHandler.log(e);
        }
    }

    public Controller getController() {
        return controller;
    }

    public UndoListener getUndoListener() {
        return undoListener;
    }

    public void init(){
        initGui();
        addWindowListener(new FrameListener(this));
        setVisible(true);
    }

    public void exit(){
        controller.exit();
    }

    public void initMenuBar(){

        JMenuBar menuBar = new JMenuBar();

        MenuHelper.initFileMenu(this, menuBar);
        MenuHelper.initEditMenu(this, menuBar);
        MenuHelper.initStyleMenu(this, menuBar);
        MenuHelper.initAlignMenu(this, menuBar);
        MenuHelper.initColorMenu(this, menuBar);
        MenuHelper.initFontMenu(this, menuBar);
        MenuHelper.initHelpMenu(this, menuBar);

        getContentPane().add(menuBar, BorderLayout.NORTH);

    }

    public void initEditor(){

        htmlTextPane.setContentType("text/html");

        JScrollPane htmlScrollPane = new JScrollPane(htmlTextPane);
        tabbedPane.addTab("HTML", htmlScrollPane);

        JScrollPane textScrollPane = new JScrollPane(plainTextPane);
        tabbedPane.addTab("Текст", textScrollPane);

        tabbedPane.setPreferredSize(new Dimension(400, 600));

        tabbedPane.addChangeListener(new TabbedPaneChangeListener(this));

        getContentPane().add(tabbedPane, BorderLayout.CENTER);

    }

    public  void initGui(){
        initMenuBar();
        initEditor();
        pack();
    }

    public void undo(){
        try{
            undoManager.undo();
        }catch (CannotUndoException e){
            ExceptionHandler.log(e);
        }

    }

    public void redo(){
        try{
            undoManager.redo();
        }catch (CannotRedoException e){
            ExceptionHandler.log(e);
        }

    }

    public void update(){
        htmlTextPane.setDocument(controller.getDocument());
    }

    public void resetUndo(){
        undoManager.discardAllEdits();
    }

    public boolean canUndo(){
        return undoManager.canUndo();
    }

    public boolean canRedo(){
        return undoManager.canRedo();
    }

    public void selectedTabChanged(){

        int tab = tabbedPane.getSelectedIndex();
        switch (tab){
            case 0: controller.setPlainText(plainTextPane.getText()); break;
            case 1: plainTextPane.setText(controller.getPlainText()); break;
        }

        this.resetUndo();
    }

    public boolean isHtmlTabSelected(){
        return tabbedPane.getSelectedIndex() == 0;
    }

    public void selectHtmlTab(){
        tabbedPane.setSelectedIndex(0);
        resetUndo();
    }

    public void showAbout(){
        JOptionPane.showMessageDialog(null, "HTML Editor", "О программе", JOptionPane.INFORMATION_MESSAGE);
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();
        switch (command){
            case "Новый" : controller.createNewDocument();
            case "Открыть" : controller.openDocument();
            case "Сохранить" : controller.saveDocument();
            case "Сохранить как..." : controller.saveDocumentAs();
            case "Выход" : controller.exit(); break;
            case "О программе" : this.showAbout(); break;
        }
    }
}
