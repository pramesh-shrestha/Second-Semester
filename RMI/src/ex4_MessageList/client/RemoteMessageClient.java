package ex4_MessageList.client;

import ex4_MessageList.server.RemoteMessageServer;
import ex4_MessageList.shared.RemoteMessageList;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class RemoteMessageClient
{
  private RemoteMessageList remoteMessageList;

  public RemoteMessageClient() throws RemoteException, NotBoundException
  {
    Registry registry = LocateRegistry.getRegistry("localhost", 1099);
    remoteMessageList = (RemoteMessageList) registry.lookup("Server");

    //loop to add message to the server
    Scanner input = new Scanner(System.in);
    for (int i = 0; i < 10; i++)
    {
      System.out.print("Enter a message > ");
      String message = input.nextLine();
      remoteMessageList.addMessage(message);
    }
  }

  public static void main(String[] args) throws NotBoundException, RemoteException
  {
    RemoteMessageClient client = new RemoteMessageClient();

  }
}
