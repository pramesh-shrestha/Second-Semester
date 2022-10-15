package example.EchoServer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerSocketHandler implements Runnable
{
  private Socket socket;
  private ObjectInputStream inFromClient;
  private ObjectOutputStream outToClient;
  public ServerSocketHandler (Socket socket) throws IOException
  {
    this.socket = socket;
    inFromClient = new ObjectInputStream(socket.getInputStream());
    outToClient = new ObjectOutputStream(socket.getOutputStream());
  }

  @Override public void run()
  {
    try
    {
      //creating an ObjectInputStream to read an Object from the client
//      ObjectInputStream inFromClient = new ObjectInputStream(socket.getInputStream());
      //creating an ObjectOutputStream to write or send the Object back to the client
//      ObjectOutputStream outToClient = new ObjectOutputStream(socket.getOutputStream());

      while (true)
      {
        String read = (String) inFromClient.readObject();//stuck here until sends something
        if (read.equalsIgnoreCase("exit"))
        {
          socket.close();
          break;
        }
        System.out.println("Received: " + read);

        //converting the object received from the client to Uppercase to send it back to the client
        String answer = read.toUpperCase();
        //sending to the client
        outToClient.writeObject(answer);
      }
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
  }
}
