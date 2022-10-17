package ex3_ex2Extension.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerSocketHandler implements Runnable
{
  private Counter counter;
  private Socket socket;
  private ObjectInputStream inputStream;
  private ObjectOutputStream outputStream;

  public ServerSocketHandler(Socket socket, Counter counter)
  {
    this.socket = socket;
    this.counter = counter;
    try
    {
      inputStream = new ObjectInputStream(socket.getInputStream());
      outputStream = new ObjectOutputStream(socket.getOutputStream());
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
        String request = (String) inputStream.readObject();
        if(request.equalsIgnoreCase("increment"))
        {
          counter.increment();
        }
        else if(request.equalsIgnoreCase("decrement"))
        {
          counter.decrement();
        }
      }

    }
    catch (IOException | ClassNotFoundException e)
    {
      throw new RuntimeException(e);
    }
  }
}
