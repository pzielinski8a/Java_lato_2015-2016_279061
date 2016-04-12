package sample.Models;

import sample.NetworkConnection;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * Created by Piotr on 2016-03-20.
 */
public class Server extends NetworkConnection {

    private int port;




    private ArrayList<User> users = new ArrayList<>();


    public Server(int port, Consumer<Serializable> onReceiveCallback) {
        super(onReceiveCallback);
        this.port = port;

        users.add(new User("piotr"));
    }

    @Override
    protected boolean isServer() {
        return true;
    }

    @Override
    protected String getIP() {
        return null;
    }

    @Override
    protected int getPort() {
        return port;
    }


    ///////moje metody


    @Override

    public ArrayList<User> getUsers() {
        return users;
    }

    @Override
    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
}