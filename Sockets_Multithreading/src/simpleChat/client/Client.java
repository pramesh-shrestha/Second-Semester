package simpleChat.client;

import java.io.IOException;
import java.net.Socket;


public class Client
{
  private Socket socket;
  public void startClient()
  {
    try {
      socket = new Socket("localhost", 2910);
      ClientSocketHandler csh = new ClientSocketHandler(socket);
      Thread thread = new Thread(csh);
      thread.start();
      }
      catch (IOException e) {
        e.printStackTrace();
      }
    }
}
