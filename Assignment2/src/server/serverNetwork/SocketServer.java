package server.serverNetwork;

import server.serverModel.ServerChatModel;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer
{
  private int totalConnections = 0;
  private ConnectionPool pool;
  private ServerChatModel serverChatModel;

  public SocketServer(ServerChatModel serverChatModel)
  {
    this.serverChatModel = serverChatModel;
  }
  public void startServer()
  {
    try
    {
      System.out.println("Server started..");
      ServerSocket serverSocket = new ServerSocket(2910);
      pool = new ConnectionPool();
      while(true)
      {
        Socket socket = serverSocket.accept();
        System.out.println("Client connected.");

        ServerSocketHandler ssh = new ServerSocketHandler(socket,serverChatModel,pool);
        pool.addConnections(ssh);
        Thread thread = new Thread(ssh);
        thread.start();
        //incrementing the connections
        totalConnections++;

      }
    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }
  }

  public int getTotalConnections()
  {
    return totalConnections;
  }

  public ConnectionPool getPool()
  {
    return pool;
  }
}
