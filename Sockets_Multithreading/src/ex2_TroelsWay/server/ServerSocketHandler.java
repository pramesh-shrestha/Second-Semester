package ex2_TroelsWay.server;



import ex2_TroelsWay.shared.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerSocketHandler implements Runnable
{
  private Server server;
  private Socket socket;
  private int id;
  private ObjectInputStream inFromClient;
  private ObjectOutputStream outToClient;

  public ServerSocketHandler(Socket socket, int id, Server server)
  {
    this.socket = socket;
    this.id = id;
    this.server = server;
    try
    {
      outToClient = new ObjectOutputStream(socket.getOutputStream());
      inFromClient = new ObjectInputStream(socket.getInputStream());
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
      //sending id to client as it connects
      outToClient.writeObject(id);
      while (true)
      {
        Message response = (Message) inFromClient.readObject();
        //getting message from server
        String messageFromServer = server.messageFromSSH(response.getMessage(),response.getId());
        //sending to the clientSocketHandler
        outToClient.writeObject(messageFromServer);
       }
    }
    catch (IOException | ClassNotFoundException e)
    {
      throw new RuntimeException(e);
    }

  }
}
