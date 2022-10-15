package ex5_SumOfTwoDigit;

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
      ServerSocket serverSocket = new ServerSocket(2910);
      System.out.println("Server started...");
      //accept connection
      Socket socket = serverSocket.accept();
      System.out.println("Connection established");
      //creating input and output streams
      ObjectOutputStream outToClient = new ObjectOutputStream(socket.getOutputStream());
      ObjectInputStream inFromClient = new ObjectInputStream(socket.getInputStream());

      //reading from the client
      int num1 = inFromClient.readInt();
      int num2 = inFromClient.readInt();
      int result = num1+num2;
      //writing the sum back to the client
      outToClient.writeInt(result);

    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }
  }
}
