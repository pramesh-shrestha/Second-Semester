package ex2_multipleClientsID.server;

import ex2_multipleClientsID.util.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerSocketHandler implements Runnable
{
  int id;
  private Socket socket;
  private ObjectInputStream in;
  private ObjectOutputStream out;


  //constructor
  public ServerSocketHandler(Socket socket, int id)
  {
    this.socket = socket;
    this.id = id;
    try
    {
      out = new ObjectOutputStream(socket.getOutputStream());
      in = new ObjectInputStream(socket.getInputStream());

    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }
  }

  //run method
  @Override
  public void run()
  {
    try
    {
      //Sending the client its id
     String ID = String.valueOf(id);
     out.writeObject(ID);
      while (true)
      {
        // Reading the message from the client.
        Message text = (Message) in.readObject();
        System.out.println(text);
        Message message = new Message("And, Hello to you, client number " + ID);
        out.writeObject(message);
      }

    }
    catch (IOException | ClassNotFoundException e)
    {
      throw new RuntimeException(e);
    }
  }

  public void sendMessage(Message msg)
  {
    try
    {
      out.writeObject(msg);
    }
    catch (IOException e)
    {
     e.printStackTrace();
    }
  }


}
