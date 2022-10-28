package ex5_MessageListCallBack.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ClientMain
{
  public static void main(String[] args) throws NotBoundException, RemoteException
  {
    RemoteMessageClient client = new RemoteMessageClient();
    client.replyMessage("asdf");
  }
}
