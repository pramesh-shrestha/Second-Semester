
package ChatSystem.Server;


import ChatSystem.transferObjects.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerSocketHandler implements Runnable
{
  private ServerMain1 server;
  private Socket socket;
  private ObjectOutputStream out;
  private ObjectInputStream in;
  private int id;

  public ServerSocketHandler(Socket socket, int id, ServerMain1 server)
  {
    this.socket = socket;
    this.server = server;
    this.id =id;
    try
    {
      out = new ObjectOutputStream(socket.getOutputStream());
      in = new ObjectInputStream(socket.getInputStream());
    }
    catch (IOException e)
    {
//
    }
  }

  @Override public void run()
  {
    try
    {
      out.writeObject(id);

        while (true)
        {
          Message message = (Message) in.readObject();
          System.out.println(message.getMsg() +" from: "+ message.getId());
          server.getPool().broadcast(message.getMsg(), message.getId());
        }

    }

    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }


  }

  public void sendMessage(Message message)
  {
    try
    {
      out.writeObject(message);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
