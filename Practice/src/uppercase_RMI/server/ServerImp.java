package uppercase_RMI.server;

import uppercase_RMI.shared.UpperCaseServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerImp implements UpperCaseServer
{
  public ServerImp() throws RemoteException
  {
    UnicastRemoteObject.exportObject(this,1099);
  }
  @Override public String toUppercase(String str) throws RemoteException
  {
    return str.toUpperCase();
  }
}
