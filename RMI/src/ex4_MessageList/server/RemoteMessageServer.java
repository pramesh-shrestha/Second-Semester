package ex4_MessageList.server;

import ex4_MessageList.shared.RemoteMessageList;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RemoteMessageServer implements RemoteMessageList
{
  private ArrayList<String> list;

  public RemoteMessageServer() throws RemoteException
  {
    list = new ArrayList<>();
    UnicastRemoteObject.exportObject(this, 0);
  }

  @Override public void addMessage(String msg) throws RemoteException
  {
    list.add(msg);
    System.out.println("Client added: " + msg);
  }

  public static void main(String[] args) throws RemoteException, AlreadyBoundException
  {
    RemoteMessageList server = new RemoteMessageServer();
    Registry registry = LocateRegistry.createRegistry(1099);
    registry.bind("Server", server);
    System.out.println("Server started..");
  }
}
