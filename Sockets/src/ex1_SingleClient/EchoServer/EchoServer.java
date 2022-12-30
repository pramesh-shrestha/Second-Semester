package ex1_SingleClient.EchoServer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer
{
  public void start()
  {

    //creating SeverSocket to receive connection request from a client
    try
    {
      ServerSocket serverSocket = new ServerSocket(2910);
      System.out.println("Starting server...");
      while(true)
      {
        //The request must be accepted using accept() method and assign to Socket object
        Socket socket = serverSocket.accept();//stuck here until client sends connection request
        System.out.println("Client connected.");

        //creating an ObjectInputStream to read an Object from the client
        ObjectInputStream inFromClient = new ObjectInputStream(socket.getInputStream());
        //creating an ObjectOutputStream to write or send the Object back to the client
        ObjectOutputStream outToClient = new ObjectOutputStream(socket.getOutputStream());

        while (true) {
          String obj = (String) inFromClient.readObject();//stuck here until sends something
          System.out.println("Received: " + obj);
          if(obj.equalsIgnoreCase("bye"))
            break;

          //converting the object received from the client to Uppercase to send it back to the client
          String answer = obj.toUpperCase();
          outToClient.writeObject(answer);
        }
        break;
      }
    }
    catch (IOException | ClassNotFoundException e)
    {
      System.out.println("Client Disconnected");
    }

  }
}
