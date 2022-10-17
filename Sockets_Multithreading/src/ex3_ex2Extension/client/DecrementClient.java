package ex3_ex2Extension.client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class DecrementClient implements Runnable
{
  @Override public void run()
  {
    try
    {
      Socket socket = new Socket("localhost", 2910);
      System.out.println("Connected to the server");

      ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
      while(true)
      {
        outToServer.writeObject("decrement");
      }
    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }
  }
}
