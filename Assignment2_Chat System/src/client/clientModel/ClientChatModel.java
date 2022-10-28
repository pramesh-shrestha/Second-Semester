package client.clientModel;


import util.PropertyChangeSubject;

import java.util.ArrayList;
import java.util.List;

public interface ClientChatModel extends PropertyChangeSubject
{
  Boolean checkUsername(String user,String password);
  String sendMessage(String user,String msg);
  Boolean login(String username, String password);

  ArrayList<String > getAllUsername();
  ArrayList<String> getAllMessages();
  Boolean sendPrivateMessage(String userName, String msg);
  List<String> getAllPrivateMessages();
}
