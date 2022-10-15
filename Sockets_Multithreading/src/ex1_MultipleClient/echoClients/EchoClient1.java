package ex1_MultipleClient.echoClients;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient1
{
  public static void main(String[] args)
  {
    try
    {
      //sending a connection request to the server
      Socket socket = new Socket("localhost", 2910);
      ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
      //read the reply from the server
      ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());

      while (true)
      {
        //send message to server
        Scanner input = new Scanner(System.in);
        System.out.println("Hey! Client");
        System.out.println("Insert what you want in UPPERCASE");
        String text = input.nextLine();
        outToServer.writeObject(text);
        if(text.equalsIgnoreCase("exit"))
        {
          socket.close();
          break;
        }
        String result = (String) inFromServer.readObject();
        System.out.println("From server: " + result);
      }
    }
    catch (IOException | ClassNotFoundException e)
    {
      throw new RuntimeException(e);
    }
  }
}
