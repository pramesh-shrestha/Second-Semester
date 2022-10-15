package chatExample.server;

import chatExample.shared.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerSocketHandler implements Runnable
{
  private Socket socket;
  private ObjectInputStream inFromClient;
  private ObjectOutputStream outToClient;
  private ConnectionPool pool;

  public ServerSocketHandler(Socket socket, ConnectionPool pool)
  {
    this.socket = socket;
    this.pool = pool;
    try
    {
      inFromClient = new ObjectInputStream(socket.getInputStream());
      outToClient = new ObjectOutputStream(socket.getOutputStream());
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
        Message message = (Message) inFromClient.readObject(); //reading message from Message class
        String messageBody = message.getMessageBody();
        System.out.println(messageBody); //printing out msg

        if(messageBody.equalsIgnoreCase("exit"))
        {
          socket.close();
          break;
        }

        pool.broadcast(message);
      }

    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
  public void sendMessageToClient(Message msg)
  {
    try
    {
      outToClient.writeObject(msg);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
