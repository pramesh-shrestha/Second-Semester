package ex8_ChatSystem;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer
{
  public static void main(String[] args)
  {
    try
    {

        ServerSocket serverSocket = new ServerSocket(2910);
        System.out.println("Server started...");
      while (true)
      {
        Socket socket = serverSocket.accept();
        System.out.println("Connection established.");
        //creating input and output streams
        ObjectOutputStream outToClient = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream inFromClient = new ObjectInputStream(socket.getInputStream());

        Scanner input = new Scanner(System.in);
        while (true)
        {
          //reading from the client

          String text = (String) inFromClient.readObject();
          System.out.println(text);
          if(text.equalsIgnoreCase("bye"))
            break;

          outToClient.writeObject(input.nextLine());
        }
        //breaking outer loop
        break;
      }
    }
    catch (IOException | ClassNotFoundException e)
    {
      System.out.println("Disconnected");
    }

  }
}
