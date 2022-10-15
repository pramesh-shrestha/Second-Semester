package simpleChat.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerSocketHandler implements Runnable
{
  private Socket socket;
  private ObjectOutputStream objectOutputStream;
  private ObjectInputStream objectInputStream;
  private ConnectionPool pool;

  public ServerSocketHandler(Socket socket, ConnectionPool pool)
  {
    this.pool = pool;
    this.socket = socket;
    try
    {

      objectInputStream = new ObjectInputStream(socket.getInputStream());
      objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
  @Override public void run()
  {
      try
      {
        while (true)
        {
          String text = (String) objectInputStream.readObject();
          if (text.equalsIgnoreCase("exit"))
          {
            socket.close();
            break;
          }
          pool.broadcastMessage(text);
        }
      }
      catch (IOException | ClassNotFoundException e)
      {
        e.printStackTrace();
      }
  }

  public void sendMessage(String msg)
  {
    try
    {
      objectOutputStream.writeObject(msg.toUpperCase());
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
