package Sockets.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
  public void startServer()
  {
  try
  {
   System.out.println("Server started..");
   ServerSocket serverSocket = new ServerSocket(2910);
   ConnectionPool pool = new ConnectionPool();
   while(true)
   {
     Socket socket = serverSocket.accept();
     System.out.println("Connection established.");
     //starting thread
     ServerSocketHandler ssh = new ServerSocketHandler(socket,pool);
     pool.addConnections(ssh);
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
