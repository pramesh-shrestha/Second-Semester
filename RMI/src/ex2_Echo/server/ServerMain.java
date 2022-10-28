package ex2_Echo.server;

import ex2_Echo.shared.RemoteEchoServer;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerMain
{
  public static void main(String[] args) throws RemoteException, AlreadyBoundException
  {
    Registry registry = LocateRegistry.createRegistry(1099);
    RemoteEchoServer server = new RemoteEchoServerImpl();
    registry.bind("Server", server);
    System.out.println("Server started..");
  }
}
