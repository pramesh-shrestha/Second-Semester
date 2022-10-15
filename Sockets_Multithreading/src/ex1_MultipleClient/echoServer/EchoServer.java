package ex1_MultipleClient.echoServer;

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

        //creating thread for each client
        ServerSocketHandler ssh = new ServerSocketHandler(socket);
        Thread thread = new Thread(ssh);
        thread.start();
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
