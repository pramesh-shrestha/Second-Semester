package ex5_MessageListCallBack.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteMessageList extends Remote
{
  void addMessage(String message, ReplyTo who) throws RemoteException;
}
