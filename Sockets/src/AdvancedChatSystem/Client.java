package AdvancedChatSystem;

import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client
{
  public static void main(String[] args)
  {

    try
    {
      Socket socket = new Socket("localhost", 6000);

      //An InputStreamReader is a bridge from byte streams to character streams: It reads bytes and decodes them into characters using a specified charset
      InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
      //An OutputStreamWriter is a bridge from character streams to byte streams: Characters written to it are encoded into bytes using a specified charset
      OutputStreamWriter outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());

      BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
      BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

      Scanner scanner = new Scanner(System.in);
      while (true)
      {
        String chat = scanner.nextLine();
        bufferedWriter.write(chat);
        bufferedWriter.newLine();
        bufferedWriter.flush();

        System.out.println("Server: " + bufferedReader.readLine());

        if (chat.equalsIgnoreCase("bye"))
          break;
      }
    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }

  }
}
