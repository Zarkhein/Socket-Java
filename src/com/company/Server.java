package com.company;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;

public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket s = new ServerSocket(6500);

            Socket client = s.accept();

            Hashtable<String, String> message = new Hashtable<String, String>();
            message.put("test", "Bonjour je suis un test! ");

            OutputStream os = client.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(message);

            client.close();
        }
        catch (IOException err){
            err.printStackTrace();
        }
    }
}
