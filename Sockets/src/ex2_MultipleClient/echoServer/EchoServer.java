package ex2_MultipleClient.echoServer;

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
      System.out.println("Server started...");
      ServerSocket serverSocket = new ServerSocket(2910);
      while(true)
      {
        Socket socket = serverSocket.accept();
        System.out.println("Connection established.");
        //Reading from the client
        ObjectInputStream inFromClient = new ObjectInputStream(socket.getInputStream());
        //Sending the result back to the client
        ObjectOutputStream outToClient = new ObjectOutputStream(socket.getOutputStream());

        while (true)
        {
          String read = (String) inFromClient.readObject();
          if(read.equalsIgnoreCase("exit"))
          {
            socket.close();
            break;
          }
          //converting the String object to uppercase
          String result = read.toUpperCase();
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
