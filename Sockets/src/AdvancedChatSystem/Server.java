package AdvancedChatSystem;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server
{
  public static void main(String[] args)
  {
    try
    {
      ServerSocket serverSocket = new ServerSocket(6000);
      while (true)
      {
        Socket socket = serverSocket.accept();

        //An InputStreamReader is a bridge from byte streams to character streams: It reads bytes and decodes them into characters using a specified charset
        //InputStreamReader/Writer is a character stream
        InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
        //An OutputStreamWriter is a bridge from character streams to byte streams: Characters written to it are encoded into bytes using a specified charset
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
            socket.getOutputStream());

        //Reads text from a character-input stream, buffering characters so as to provide for the efficient reading of characters, arrays, and lines.
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        //Writes text to a character-output stream, buffering characters so as to provide for the efficient writing of single characters, arrays, and strings.
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

        Scanner input = new Scanner(System.in);
        while (true)
        {
          //reading from the client
          String msgFromClient = bufferedReader.readLine();
          System.out.println("Client: " + msgFromClient);

          //sending data to the client
          String chat = input.nextLine();
          bufferedWriter.write(chat);
          bufferedWriter.newLine();
          bufferedWriter.flush();

          if (msgFromClient.equalsIgnoreCase("bye"))
            break;
        }
      }
    }
    catch(IOException e)
      {
        throw new RuntimeException(e);
      }
  }
}
