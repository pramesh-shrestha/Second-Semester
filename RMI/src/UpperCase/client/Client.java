package UpperCase.client;

import UpperCase.shared.IUppercaseServer;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client
{
  private IUppercaseServer server;

  public Client()
  {
  }

  public void startClient() throws RemoteException, NotBoundException
  {
    Registry registry = LocateRegistry.getRegistry("localhost", 1099);
    server = (IUppercaseServer)registry.lookup("Server");
  }

  public  String toUppercase(String arg) throws RemoteException
  {
    try
    {
      return  server.toUppercase(arg);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException(e);
    }
  }
}
