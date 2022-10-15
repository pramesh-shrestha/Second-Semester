package chatExample.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer
{
  public void start()
  {
    try
    {
      ServerSocket serverSocket = new ServerSocket(2910);
      ConnectionPool pool = new ConnectionPool();
      System.out.println("Server started..");
      while(true)
      {
        Socket socket = serverSocket.accept();
        //Create serverSocketHandler
        ServerSocketHandler ssh = new ServerSocketHandler(socket, pool);
        pool.addConnection(ssh);

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
