package ex1_MultipleClient.echoServer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerSocketHandler implements Runnable
{
  private Socket socket;
  private ObjectInputStream inFromClient;
  private ObjectOutputStream outToClient;

  public ServerSocketHandler(Socket socket)
  {
    this.socket = socket;
    try
    {
      inFromClient = new ObjectInputStream(socket.getInputStream());
      outToClient = new ObjectOutputStream(socket.getOutputStream());
    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }
  }
  @Override public void run()
  {
    try
    {
      while (true)
      {
        String read = (String) inFromClient.readObject();
        if(read.equalsIgnoreCase("exit"))
        {
          socket.close();
          break;
        }
        //converting the String object to uppercase
        String result = read.toUpperCase();
        outToClient.writeObject(result);
      }
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
  }
}
