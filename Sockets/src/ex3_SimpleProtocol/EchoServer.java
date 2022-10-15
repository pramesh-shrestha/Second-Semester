package ex3_SimpleProtocol;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer
{
  public static void main(String[] args)
  {
    try
    {

      //receive the request
      ServerSocket serverSocket = new ServerSocket(2910);
      System.out.println("Server started...");
      //accept the request

      while(true)
      {
        Socket socket = serverSocket.accept();
        System.out.println("Connection established.");
        //creating input and output stream
        ObjectOutputStream outToClient = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream inFromClient = new ObjectInputStream(socket.getInputStream());

        while (true)
        {
          //sending first message to the client
          outToClient.writeObject("How can I help?");

          //read the request from the client
          String selection =(String) inFromClient.readObject();
          if(selection.equalsIgnoreCase("stop")){
            System.out.println("Client Disconnected");
            break;
          }

          //second reply to the client
          outToClient.writeObject("What do you want to convert?");

          //reading from client
          String text = (String) inFromClient.readObject();

          //third reply to the client
          if(selection.equalsIgnoreCase("uppercase"))
          {
            outToClient.writeObject(text.toUpperCase());
          }
          else if (selection.equalsIgnoreCase("lowercase"))
          {
            outToClient.writeObject(text.toLowerCase());
          }
          else
          {
            System.out.println("Disconnected");
            break;
          }
        }
        //breaking outer while loop
        break;


      }
    }
    catch (IOException | ClassNotFoundException e)
    {
      System.out.println("Server Disconnected");
    }
  }
}
