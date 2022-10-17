package ex3_ex2Extension.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
  ServerSocket serverSocket;

  public void startServer()
  {
    try
    {
      System.out.println("Server started..");
      serverSocket = new ServerSocket(2910);
      Counter counter = new Counter(1000,0);
      while (true)
      {
        Socket socket = serverSocket.accept();
        System.out.println("Client connected");

        //creates new Thread
        Thread thread = new Thread(new ServerSocketHandler(socket, counter));
        thread.start();
      }
    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }
  }
}
