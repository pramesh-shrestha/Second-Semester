package ex8_ChatSystem;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient
{
  public static void main(String[] args)
  {
    try
    {
      //request connection
      Socket socket = new Socket("10.154.202.37",0204);
      //creating input and output streams
      ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
      ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());

      Scanner input = new Scanner(System.in);
      while(true)
      {
        outToServer.writeObject(input.nextLine());
        String text = (String)inFromServer.readObject();
        System.out.println(text);
        if(text.equalsIgnoreCase("bye"))
        {
          break;
        }
      }
    }
    catch (IOException | ClassNotFoundException e)
    {
      System.out.println("Disconnected");
    }

  }
}
