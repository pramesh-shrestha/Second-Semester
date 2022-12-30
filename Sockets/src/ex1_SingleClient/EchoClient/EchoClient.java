package ex1_SingleClient.EchoClient;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient
{
  public void runClient()
  {

    try {
      //connect to server
      Socket socket = new Socket("localhost", 2910); //127.0.0.1 localhost IP address
      ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
      ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());

      //send message to server
      Scanner input = new Scanner(System.in);
      while (true) {
        System.out.println("Insert what you want in UPPERCASE");
        String text = input.nextLine();
        outToServer.writeObject(text);
        if(text.equalsIgnoreCase("bye"))
        {
          break;
        }

        //read result from server

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
