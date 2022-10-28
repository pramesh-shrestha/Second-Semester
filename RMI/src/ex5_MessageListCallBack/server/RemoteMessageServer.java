package ex5_MessageListCallBack.server;



import ex5_MessageListCallBack.client.RemoteMessageClient;
import ex5_MessageListCallBack.shared.RemoteMessageList;
import ex5_MessageListCallBack.shared.ReplyTo;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RemoteMessageServer implements RemoteMessageList
{
  private ArrayList<String> list;


  public RemoteMessageServer() throws RemoteException, NotBoundException
  {
    list = new ArrayList<>();
    UnicastRemoteObject.exportObject(this, 0);
  }

  @Override public void addMessage(String msg, ReplyTo replyTo) throws RemoteException
  {
    list.add(msg);
    System.out.println(msg);

  }


}
