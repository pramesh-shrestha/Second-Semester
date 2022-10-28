package ex4_MessageList.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteMessageList extends Remote
{
  void addMessage(String msg) throws RemoteException;
}
