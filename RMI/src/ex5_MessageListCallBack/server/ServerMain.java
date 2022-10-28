package ex5_MessageListCallBack.server;

import ex5_MessageListCallBack.shared.RemoteMessageList;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerMain
{
  public static void main(String[] args)
      throws RemoteException, AlreadyBoundException, NotBoundException
  {
    Registry registry = LocateRegistry.createRegistry(1099);
    RemoteMessageList server = new RemoteMessageServer();
    registry.bind("Server", server);
    System.out.println("Server started..");
  }
}
