package Sockets;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer
{
  public static void main(String[] args)
  {
    try
    {

      ServerSocket serverSocket = new ServerSocket(2910);
      System.out.println("Server started");
      while (true)
      {
        Socket socket = serverSocket.accept();
        System.out.println("Client connected");
        ObjectInputStream inFromClient = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream outToClient = new ObjectOutputStream(socket.getOutputStream());

      while(true)
      {
        outToClient.writeObject("Hello, how can I help you?");
        String str = (String) inFromClient.readObject();
        String result = null;

        if(str.equalsIgnoreCase("uppercase"))
        {
          outToClient.writeObject("What do you want to convert?");
          str = (String) inFromClient.readObject();
          result = str.toUpperCase();
        }

        else if (str.equalsIgnoreCase("lowercase"))
        {
          outToClient.writeObject("What do you want to convert?");
          str = (String) inFromClient.readObject();
          result = str.toLowerCase();
        }

        outToClient.writeObject(result);
      }
      }

    }
    catch (IOException | ClassNotFoundException e)
    {
      throw new RuntimeException(e);
    }

  }
}
