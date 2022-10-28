package ex2_Echo.server;

import ex2_Echo.shared.RemoteEchoServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteEchoServerImpl implements RemoteEchoServer
{
  public RemoteEchoServerImpl() throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
  }

  @Override public String toUppercase(String msg) throws RemoteException
  {
    return msg.toUpperCase();
  }
}
