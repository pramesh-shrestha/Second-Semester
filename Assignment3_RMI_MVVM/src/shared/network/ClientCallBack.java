package shared.network;

import shared.Msg;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientCallBack extends Remote
{
  void updateMessage(Msg msg) throws RemoteException;
  void updateUser(String user) throws RemoteException;
}
