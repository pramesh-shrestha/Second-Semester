package ex4_LoginSystem.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient
{
  public void startClient()
  {
    try
    {

    //send a connection request
      Socket socket = new Socket("localhost", 2910);
      //creating input and output streams
      ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
      ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());

      Scanner input = new Scanner(System.in);
      //sending connect to server
      String connect = input.nextLine();
      outToServer.writeObject(connect);
      //receive a string(username)
      System.out.println(inFromServer.readObject());
      //send username
      String user = input.nextLine();
      outToServer.writeObject(user);
      //receive a string(password)
      System.out.println(inFromServer.readObject());
      //send password
      outToServer.writeObject(input.nextLine());
      //receive approved string
      System.out.println("Status: " + inFromServer.readObject());
    }
    catch (IOException | ClassNotFoundException e)
      {
        System.out.println("Server Disconnected");
      }
  }
}
