package server;

import server.serverModel.ServerChatModelManager;
import server.serverNetwork.RMIServer;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

public class RunServer
{
  public static void main(String[] args) throws RemoteException, AlreadyBoundException
  {
    RMIServer server = new RMIServer(new ServerChatModelManager());
    server.startServer();


  }

}
