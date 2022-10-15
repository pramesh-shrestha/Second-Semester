package ex5_SumOfTwoDigit;

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
      //request connection
      Socket socket = new Socket("localhost",2910);
      //creating input and output streams
      ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
      ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());
      //sending digits
      System.out.println("Successfully, connected to sum server");
      Scanner input = new Scanner(System.in);
      System.out.println("Enter your first digit");
      outToServer.writeInt(input.nextInt());
      System.out.println("Enter your second digit");
      outToServer.writeInt(input.nextInt());
      int result = inFromServer.readInt();
      //reading sum from the server
      System.out.println(result);
    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }
  }
}
