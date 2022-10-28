package ex3_MultipleBridges.server;

import ex3_MultipleBridges.shared.IStringChangingServer;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerMain
{
  public static void main(String[] args) throws RemoteException, AlreadyBoundException
  {
    Registry registry = LocateRegistry.createRegistry(1099);
    IStringChangingServer server = new StringChangingServer();
    registry.bind("StringChangingServer", server);
  }
}
