package ex3_MultipleBridges.server;

import ex3_MultipleBridges.shared.IStringChangingServer;
import ex3_MultipleBridges.shared.IToRandomCase;
import ex3_MultipleBridges.shared.IToUpperCase;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class StringChangingServer implements IStringChangingServer
{
  public StringChangingServer() throws RemoteException
  {
    UnicastRemoteObject.exportObject(this,0);
  }

  @Override public IToUpperCase getUpperCase() throws RemoteException
  {
    IToUpperCase upperCase = new ToUpperCase();
    return upperCase;
  }

  @Override public IToRandomCase getRandomCase() throws RemoteException
  {
    return new ToRandomCase();
  }
}
