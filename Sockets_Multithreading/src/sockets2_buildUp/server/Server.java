package sockets2_buildUp.server;

import sockets2_buildUp.util.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public void startServer() {
        System.out.println("Starting server...");
        try{
            ServerSocket serverSocket = new ServerSocket(2910);

            ConnectionPool connectionPool = new ConnectionPool(); //each client will have its own pool if we put it inside while loop

            while(true){
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                SocketConnection socketConnection = new SocketConnection(socket, connectionPool);
                connectionPool.addClient(socketConnection);
                Thread thread = new Thread(socketConnection);
                thread.start();

            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
