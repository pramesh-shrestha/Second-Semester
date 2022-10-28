package ex3_MultipleBridges.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IToUpperCase extends Remote
{
  String toUppercase(String arg) throws RemoteException;
}
