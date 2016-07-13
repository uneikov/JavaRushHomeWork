package com.javarush.test.level30.lesson15.big01.client;

/**
 * Created by URAN on 13.07.2016.
 */
public class ClientGuiController extends Client {

    private ClientGuiModel model = new ClientGuiModel();
    private ClientGuiView view =new ClientGuiView(this);

    public void run(){
        getSocketThread().run();
    }

    public class GuiSocketThread extends SocketThread{
        @Override
        protected void processIncomingMessage(String message) {
            model.setNewMessage(message);
            view.refreshMessages();
        }

        @Override
        protected void informAboutAddingNewUser(String userName) {
            model.addUser(userName);
            view.refreshUsers();
        }

        @Override
        protected void informAboutDeletingNewUser(String userName) {
            model.deleteUser(userName);
            view.refreshUsers();
        }

        @Override
        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            view.notifyConnectionStatusChanged(clientConnected);
        }
    }

    @Override
    protected SocketThread getSocketThread() {
        return new GuiSocketThread();
    }

    public String getServerAddress(){
        return view.getServerAddress();
    }

    public int getServerPort(){
        return view.getServerPort();
    }

    public String getUserName(){
        return view.getUserName();
    }

    public ClientGuiModel getModel(){
        return model;
    }

    public static void main(String[] args) {
        ClientGuiController controller = new ClientGuiController();
        controller.run();
    }
}
