package simpleChat.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client
{
//  private Socket socket;
//  private ObjectInputStream inputStream;
//  private ObjectOutputStream outputStream;
//  public Client()
//  {
//    try
//    {
//      socket = new Socket("localhost",2910);
//      outputStream = new ObjectOutputStream(socket.getOutputStream());
//      inputStream = new ObjectInputStream(socket.getInputStream());
//    }
//    catch (IOException e)
//    {
//      e.printStackTrace();
//    }
//  }
//  public void startClient()
//  {
//    try
//    {
////      Socket socket = new Socket("localhost",2910);
////      ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
////      ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
//
//      Scanner input = new Scanner(System.in);
//      while (true)
//      {
//        System.out.println("Write message >");
//        //send message to the client
//        String text = input.nextLine();
//      outputStream.writeObject(text);
//      if(text.equalsIgnoreCase("exit"))
//      {
//        socket.close();
//        break;
//      }
//      //read message from the client
//        String response = (String) inputStream.readObject();
//        System.out.println(response);
//      }
//    }
//    catch (IOException | ClassNotFoundException e)
//    {
//      e.printStackTrace();
//    }
//  }

  Socket socket;

  public void startClient()
  {
    try
    {
      socket = new Socket("localhost", 2910);
      ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());

      ClientSocketHandler csh = new ClientSocketHandler(socket);
      Thread thread = new Thread(csh);
      thread.start();

      Scanner input = new Scanner(System.in);

        while (true)
        {
          System.out.println("Write message >");
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
