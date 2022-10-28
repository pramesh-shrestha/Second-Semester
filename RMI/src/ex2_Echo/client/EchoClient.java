package ex2_Echo.client;

import ex2_Echo.shared.RemoteEchoServer;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class EchoClient
{
  private RemoteEchoServer server;

  public EchoClient() throws RemoteException, NotBoundException
  {
    Registry registry = LocateRegistry.getRegistry("localhost", 1099);
    server = (RemoteEchoServer) registry.lookup("Server");
  }

  public void addMessage(String msg) throws RemoteException
  {
    System.out.println("Request > " + msg);
    String result = server.toUppercase(msg);
    System.out.println("Result > " + result);
  }
}
