package server.serverModel;

import shared.User;
import util.PropertyChangeSubject;

import java.util.ArrayList;

public interface ServerChatModel extends PropertyChangeSubject
{
  void addUser(User user);
  boolean login(String username, String password);
  Boolean checkUser(String user);
  int totalUsers();

  String addMsg(String user,String message);
  ArrayList<String> getAllUsers();
  ArrayList<String> getAllMessages();
  Boolean addPrivateMessage(String user, String text);
  ArrayList<String> getPrivateMessages();
}
