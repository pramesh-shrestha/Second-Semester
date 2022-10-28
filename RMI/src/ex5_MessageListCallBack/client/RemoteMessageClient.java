package ex5_MessageListCallBack.client;

import ex5_MessageListCallBack.shared.RemoteMessageList;
import ex5_MessageListCallBack.shared.ReplyTo;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RemoteMessageClient implements ReplyTo
{
  private RemoteMessageList remoteMessageList;

  public RemoteMessageClient() throws RemoteException, NotBoundException
  {
    Registry registry = LocateRegistry.getRegistry("localhost", 1099);
    remoteMessageList = (RemoteMessageList) registry.lookup("Server");
  }

  @Override public void replyMessage(String msg) throws RemoteException
  {
    System.out.println(msg);
  }


}
