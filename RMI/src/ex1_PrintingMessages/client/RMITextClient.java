package ex1_PrintingMessages.client;

import ex1_PrintingMessages.shared.ITextServer;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMITextClient
{
  private ITextServer server;
  public RMITextClient() throws RemoteException, NotBoundException
  {
    Registry registry = LocateRegistry.getRegistry("localhost", 1099);
    server = (ITextServer) registry.lookup("Server");
  }

  public void sendText(String text)
  {
    try
    {
      server.printText(text);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException(e);
    }
  }
}
