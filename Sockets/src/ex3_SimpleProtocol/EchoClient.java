package ex3_SimpleProtocol;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class EchoClient
{
  public static void main(String[] args)
  {
    try
    {
      Scanner input = new Scanner(System.in);

        //send a connection request
        Socket socket = new Socket("localhost", 2910);
        //creating input and output streams
        ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
      while (true)
      {
        //read from the server
        String argument1 = (String) inFromServer.readObject();
        System.out.println("From server: " + argument1);

        //send a message
        String select = input.nextLine();
        outToServer.writeObject(select);

        //read from the server
        String argument = (String) inFromServer.readObject();
        System.out.println("From server: " + argument);

        //sends argument to be converted
        String text = input.nextLine();
        outToServer.writeObject(text);

        //read a reply from the server
        System.out.println("From server: " + inFromServer.readObject());
      }
    }
    catch (ClassNotFoundException | IOException e)
    {
      System.out.println("Server Disconnected");
    }
  }
}
