package shared.network;

import shared.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IRMIServer extends Remote
{
  void addUser(User user) throws RemoteException;
  boolean login(String username, String password) throws RemoteException;
  boolean checkUser(String user) throws RemoteException;
  String addMsg(String user,String message) throws RemoteException;
  void registerCallBack(ClientCallBack ccb) throws RemoteException;

  ArrayList<String> getAllUsers() throws RemoteException;
  ArrayList<String> getAllMessages() throws RemoteException;
  Boolean addPrivateMessage(String user, String text) throws RemoteException;
  ArrayList<String> getPrivateMessages() throws RemoteException;
}
