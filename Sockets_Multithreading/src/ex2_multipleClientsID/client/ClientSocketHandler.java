package ex2_multipleClientsID.client;

import ex2_multipleClientsID.util.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class  ClientSocketHandler implements Runnable
{
  private Socket socket;
  private ObjectInputStream in;
  private ObjectOutputStream out;

  public ClientSocketHandler(Socket socket)
  {
    this.socket = socket;
    try
    {
      in = new ObjectInputStream(socket.getInputStream());
      out = new ObjectOutputStream(socket.getOutputStream());
    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }
  }
  @Override public void run()
  {
    Scanner input = new Scanner(System.in);
    try
    {
      //receiving id from the server and storing it.
      String id = (String) in.readObject();
      System.out.println("Your Client ID is: " + id);
      input.nextLine(); //just to make the program wait until I hit enter
      while ( true)
      {
        Message sendMessage = new Message("Hello from client number: " + id);
        out.writeObject(sendMessage);
        Message response = (Message) in.readObject();
        System.out.println(response);
      }
    }
    catch (IOException | ClassNotFoundException e)
    {
      throw new RuntimeException(e);
    }
  }
}
