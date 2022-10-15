package ex2_TroelsWay.client;


import ex2_TroelsWay.shared.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientSocketHandler implements Runnable
{
  private Socket socket;
  private Client client;
  private ObjectInputStream inFromServer;
  private ObjectOutputStream outToServer;

  public ClientSocketHandler(Socket socket, Client client)
  {
    this.socket = socket;
    this.client = client;
    try
    {
      inFromServer = new ObjectInputStream(socket.getInputStream());
      outToServer = new ObjectOutputStream(socket.getOutputStream());
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
      //getting id from the server
      int id = (int) inFromServer.readObject();
      //sending it forward to the Client
      client.setId(id);

      while (true)
      {
       //receiving from server
        String msgFromServer = (String) inFromServer.readObject();
        client.msgToClient(msgFromServer);
      }

    }
    catch (IOException | ClassNotFoundException e)
    {
      throw new RuntimeException(e);
    }
  }

  //We make this method to write to the server here and call from main thread,
  // because we want client to be able to write and read simultaneously without having to wait for each other.
  public void sendMessageToServer(String message, int id)
  {
    Message msg = new Message(message,id);
    try
    {
      outToServer.writeObject(msg);
    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }
  }


}
