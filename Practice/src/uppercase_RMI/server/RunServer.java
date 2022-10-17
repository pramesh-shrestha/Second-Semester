package uppercase_RMI.server;

import uppercase_RMI.shared.UpperCaseServer;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RunServer
{
  public static void main(String[] args) throws RemoteException, AlreadyBoundException
  {
    UpperCaseServer server = new ServerImp(); //create server instance
    Registry registry = LocateRegistry.createRegistry(1099); //create registry
    registry.bind("server", server); //put server into the registry, the name can be anything
  }
}
