package ChatSystem.Client;

import ChatSystem.transferObjects.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientSocketHandler implements Runnable
{
  private Socket socket;
  private ObjectOutputStream out;
  private ObjectInputStream in;
  private ClientMain1 client;

  public ClientSocketHandler(Socket socket, ClientMain1 client)
  {
    this.socket = socket;
    this.client = client;
    try
    {
      out = new ObjectOutputStream(socket.getOutputStream());
      in = new ObjectInputStream(socket.getInputStream());
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  public void run()
  {
    try
    {
      int id = (int) in.readObject();
      client.setId(id);

      while (true)
      {

        Message messFromServer = (Message)in.readObject();
        System.out.println("Read message " + messFromServer.getMsg());

        client.messageReceived(messFromServer);


      }
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }

  }

  public void sendMessageToServer(Message msg)
  {

    try
    {
      out.writeObject(msg);
      System.out.println(msg.getId() + msg.getMsg());

    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
