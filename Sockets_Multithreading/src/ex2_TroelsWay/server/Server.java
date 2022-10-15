package ex2_TroelsWay.server;

import ex2_multipleClientsID.util.Message;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
  private int id = 0;

  public void startServer()
  {
    try
    {
      System.out.println("Server started..");
      ServerSocket serverSocket = new ServerSocket(2910);
      System.out.println("Waiting for client to connect..");

      while (true)
      {
        Socket socket = serverSocket.accept();
        System.out.println("Connection established.");

        //Passing the connection to thread
        ServerSocketHandler ssh = new ServerSocketHandler(socket,id,this);
        id++;
        Thread thread = new Thread(ssh);
        thread.start();
        //incrementing id as number of connection incomes

      }

    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }
  }

  public String messageFromSSH(String message, int id)
  {
    System.out.println("From client: " + message);
    String msg = "And hello to the client " + id;
    return msg;
  }


}
