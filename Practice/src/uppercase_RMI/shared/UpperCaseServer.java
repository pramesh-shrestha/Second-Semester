package uppercase_RMI.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UpperCaseServer extends Remote
{
  String toUppercase(String str) throws RemoteException;
}
