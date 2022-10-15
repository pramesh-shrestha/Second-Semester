package ex4_LoginSystem.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer
{
  public void startServer()
  {
    try
    {
      //waiting for a connection request
      ServerSocket serverSocket = new ServerSocket(2910);
      System.out.println("Server started...");
      //accept connection

        Socket socket = serverSocket.accept();
        System.out.println("Connection established.");

        ObjectInputStream inFromClient = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream outToClient = new ObjectOutputStream(socket.getOutputStream());

        //read connect from server
        String connect = (String) inFromClient.readObject();
        if(!connect.equalsIgnoreCase("connect"))
        {
          outToClient.writeObject("Disconnected");
          socket.close();
        }
        else
          System.out.println("Client connected.");
        //requesting username
        outToClient.writeObject("Username?");
        //reading username from the client
        System.out.println("Username: " + inFromClient.readObject());
        //requesting password
        outToClient.writeObject("Password?");
        //reading username from the client
        System.out.println("Password: " + inFromClient.readObject());
        //printing out clients IP
        String clientIP = socket.getInetAddress().getHostAddress();
        System.out.println("Client's IP: " + clientIP);
        //sending approval
        outToClient.writeObject("Approved");
      }
    catch (IOException | ClassNotFoundException e)
    {
      throw new RuntimeException(e);
    }
  }
}
