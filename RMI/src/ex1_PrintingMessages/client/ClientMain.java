package ex1_PrintingMessages.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ClientMain
{
  public static void main(String[] args) throws RemoteException, NotBoundException
  {
    RMITextClient client = new RMITextClient();
    client.sendText("Hey buddy");
    client.sendText("It's getting cold day after day.");
  }
}
