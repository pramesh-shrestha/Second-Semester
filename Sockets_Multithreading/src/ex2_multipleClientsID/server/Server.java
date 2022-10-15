package ex2_multipleClientsID.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server
{
  public void startServer()
  {
    try
    {
      ServerSocket serverSocket = new ServerSocket(2910);
      int id = 0;
      System.out.println("Server started..");
      //accept connection
      while (true)
      {
        Socket socket = serverSocket.accept();
        //pass this socket to a thread
        ServerSocketHandler ssh = new ServerSocketHandler(socket, id);
        id++;
        Thread thread = new Thread(ssh);
        thread.start();
      }
    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }
  }
}
