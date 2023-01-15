package chatExample.client;

import chatExample.shared.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient
{
  private ObjectInputStream inFromServer;
  public void start()
  {
    try
    {
      Socket socket = new Socket("localhost", 2910);
      ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
      inFromServer = new ObjectInputStream(socket.getInputStream());

      Thread thread = new Thread(this::listenToServer);//It basically says,run listenToServer() method in a different thread
      thread.setDaemon(true); //It means if it is the last thread running, it will terminate by itself
      thread.start();

      Scanner input = new Scanner(System.in);
      while(true)

      {
        System.out.println("Input > ");
        String msg = input.nextLine();
        Message message = new Message(msg);
        //sending out to server
        outToServer.writeObject(message);

        if(msg.equalsIgnoreCase("exit"))
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

  private void listenToServer ()
  {
    //reading from the server

    try
    {
      while (true) //constantly reading from the server
      {
        Message response = (Message) inFromServer.readObject();
        System.out.println(response.getMessageBody());
      }
    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }
    catch (ClassNotFoundException e)
    {
      e.printStackTrace();
    }

  }
}
