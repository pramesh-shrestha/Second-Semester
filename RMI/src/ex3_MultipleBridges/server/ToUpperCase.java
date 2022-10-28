package ex3_MultipleBridges.server;

import ex3_MultipleBridges.shared.IToUpperCase;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ToUpperCase implements IToUpperCase
{
  public ToUpperCase() throws RemoteException
  {
    UnicastRemoteObject.exportObject(this,0);
  }

  @Override public String toUppercase(String arg) throws RemoteException
  {
    return arg.toUpperCase();
  }
}
