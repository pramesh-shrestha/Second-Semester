package ex2_TroelsWay.client;

import ex2_multipleClientsID.util.Message;

import java.io.IOException;
import java.net.Socket;

public class Client
{
  private int id;


  public void startClient()
  {
    try
    {
      Socket socket = new Socket("localhost", 2910);
      //passing this socket to a thread
      ClientSocketHandler csh = new ClientSocketHandler(socket, this);
      Thread thread  = new Thread(csh);
      thread.start();

      while (true)
      {
        //calling this method from main thread so that reading from and writing to server runs in different thread.
        csh.sendMessageToServer("Hello from client number" + id , id);
      }

    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }
  }

  //method to set id of client
  public void setId(int id)
  {
    this.id = id;
  }

  public void msgToClient(String message)
  {
    System.out.println("From server: " + message);
  }


}
