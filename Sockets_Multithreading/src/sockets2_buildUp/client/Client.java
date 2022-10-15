package sockets2_buildUp.client;

import sockets2_buildUp.util.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private ObjectOutputStream outToServer;

    private ObjectInputStream inFromServer;
    public void startClient()
    {
        try
        {
            Socket socket = new Socket("localhost", 2910);
            System.out.println("Connected to the server");

            outToServer = new ObjectOutputStream(socket.getOutputStream());
            inFromServer = new ObjectInputStream(socket.getInputStream());

            Thread thread = new Thread(()-> listenToMessages());
            thread.setDaemon(true);
            thread.start();

            Scanner scanner = new Scanner(System.in);

            while (true)
            {
                System.out.println("Please type message >");

                String scanned = scanner.nextLine();

                Message message = new Message(scanned);
                outToServer.writeObject(message);

                if (message.getMessageBody().equalsIgnoreCase("exit"))
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

        public void listenToMessages()
        {
            while (true)
            {
                Message result = null;
                try
                {
                    result = (Message) inFromServer.readObject();
                    System.out.println("Client received: " + result);
                }
                catch (IOException | ClassNotFoundException e)
                {
                    throw new RuntimeException(e);
                }

            }
        }

}
