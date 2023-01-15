package Sockets.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class  ClientSocketHandler implements Runnable
{
  private Socket socket;
  private ObjectInputStream inputStream;
  private ObjectOutputStream outputStream;
  public ClientSocketHandler(Socket socket)
  {
    this.socket = socket;
    try
    {
      //starting new thread
      new Thread(() -> listener()).start();
      outputStream = new ObjectOutputStream(socket.getOutputStream());
    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }
  }

  //thread to listen to the server in parallel to main thread
  private void listener()
  {
    try
    {
      inputStream = new ObjectInputStream(socket.getInputStream());
      while (true)
      {
        //read message from the client
        String response = (String) inputStream.readObject();
        System.out.println(response);
      }
    }
    catch (IOException | ClassNotFoundException e)
    {
      throw new RuntimeException(e);
    }
  }

  @Override public void run()
  {
    try
    {
      Scanner input = new Scanner(System.in);

      while (true)
      {
        System.out.println("Write new message >");
        String text = input.nextLine();
        outputStream.writeObject(text);
        if (text.equalsIgnoreCase("exit"))
        {
          socket.close();
          break;
        }
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

}
