package example.EchoServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer
{
  public void start()
  {

    //creating SeverSocket to receive connection request from a client
    try
    {
      ServerSocket serverSocket = new ServerSocket(2910);
      System.out.println("Starting server...");
      while (true)
      {
        //We accept the client
        Socket socket = serverSocket.accept();
        System.out.println("Client connected.");

        //We create a thread to handle the client
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
