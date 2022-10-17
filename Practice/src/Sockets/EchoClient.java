package Sockets;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient
{
  public static void main(String[] args)
  {
    try
    {
        Socket socket = new Socket("localhost",2910);
        ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());
      while(true)
      {
        String result = (String) inFromServer.readObject();
        System.out.println(result);
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();
        outToServer.writeObject(text);
        System.out.println((String) inFromServer.readObject());
        outToServer.writeObject(input.nextLine());
        System.out.println((String) inFromServer.readObject());
      }


    }
    catch (IOException | ClassNotFoundException e)
    {
      throw new RuntimeException(e);
    }
  }
}
