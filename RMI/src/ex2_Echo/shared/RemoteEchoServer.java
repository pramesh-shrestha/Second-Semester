package ex2_Echo.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteEchoServer extends Remote
{
  String toUppercase(String msg) throws RemoteException;
}
