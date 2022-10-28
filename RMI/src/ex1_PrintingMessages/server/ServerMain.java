package ex1_PrintingMessages.server;

import ex1_PrintingMessages.shared.ITextServer;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerMain
{
  public static void main(String[] args) throws RemoteException, AlreadyBoundException
  {
    ITextServer server = new RMITextServer();
    Registry registry = LocateRegistry.createRegistry(1099);//We must use 1099 as a port number, no other choice
    //We must put a server on the registry by binding
    registry.bind("Server", server);//When the client wants to get the server object, it should get it by the name "Server"
    System.out.println("Server started..");

  }
}
