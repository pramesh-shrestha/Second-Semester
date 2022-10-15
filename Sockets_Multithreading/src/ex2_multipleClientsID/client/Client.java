package ex2_multipleClientsID.client;
import java.io.IOException;
import java.net.Socket;


public class Client
{
  public void startClient()
  {
    try
    {
      Socket socket = new Socket("localhost", 2910);

      //passing this socket instance to a thread
      ClientSocketHandler csh = new ClientSocketHandler(socket);
      Thread thread = new Thread(csh);
      //making this thread daemon so that it kills itself whenever it is the only thread running
      thread.start();

    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }
  }

}
