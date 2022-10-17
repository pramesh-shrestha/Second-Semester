package simpleChat.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;


public class ClientSocketHandler implements Runnable
{
  private Socket socket;
  private ObjectInputStream inputStream;
  public ClientSocketHandler(Socket socket)
  {
    this.socket = socket;
    try
    {
      inputStream = new ObjectInputStream(socket.getInputStream());
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
      //read message from the client
        String response = (String) inputStream.readObject();
        System.out.println(response);
      }

      }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
  }

}
