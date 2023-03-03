package UpperCase.server;

import UpperCase.shared.IUppercaseServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server implements IUppercaseServer
{
  //Server must have a specific constructor where I export the server objects so that it is available remotely

  public Server() throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
  }

  @Override public String toUppercase(String str) throws RemoteException
  {
    try
    {
      Thread.sleep(10);
      return str.toUpperCase();
    }
    catch (InterruptedException e)
    {
      throw new RuntimeException(e);
    }

  }
}
