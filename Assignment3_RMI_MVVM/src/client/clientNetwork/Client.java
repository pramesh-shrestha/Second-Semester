package client.clientNetwork;

import util.PropertyChangeSubject;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public interface Client extends PropertyChangeSubject
{
  boolean login(String username, String password);
  void startClient();
  boolean checkUser(String user,String password);
  String sendMessage(String user, String msg);
  ArrayList<String> getAllUsers();
  ArrayList<String> getAllText();

  Boolean sendPrivateMessage(String userName, String msg);
  List<String> getAllPrivateMessages();
}
