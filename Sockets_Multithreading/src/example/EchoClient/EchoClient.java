package example.EchoClient;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient
{
  public void runClient()
  {
    try
    {
      //connect to server
      Socket socket = new Socket("localhost",2910); //127.0.0.1 localhost IP address
      ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
      //read result from server
      ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());

      while (true)
      {
        Scanner input = new Scanner(System.in);
        //send message to server
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
      e.printStackTrace();
    }
  }
}
