package server.serverModel;

import shared.Msg;
import shared.User;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;


public class ServerChatModelManager implements ServerChatModel
{
  private ArrayList<User> loginCredentials;
  private ArrayList<String> userNames;
  private PropertyChangeSupport support;
  private ArrayList<String> messages;
  private ArrayList<String> privateMessages;

  public ServerChatModelManager()
  {
    loginCredentials = new ArrayList<>();
    userNames = new ArrayList<>();
    messages = new ArrayList<>();
    privateMessages = new ArrayList<>();
    support = new PropertyChangeSupport(this);
  }

  @Override
  public void addUser(User user)
  {
    loginCredentials.add(user);
  }


  @Override
  public boolean login(String username, String password)
  {
    for (int i = 0; i < loginCredentials.size(); i++)
    {
      if(loginCredentials.get(i).getUsername().equals(username) && loginCredentials.get(i).getPassword().equals(password))
      {
        userNames.add(username);
        support.firePropertyChange("userLoggedIn", null, username);
        return true;
      }
    }
    return false;
  }

  @Override public boolean checkUser(String user)
  {
    System.out.println("i am here");
    for (int i = 0; i < loginCredentials.size(); i++)
    {
      if(loginCredentials.get(i).getUsername().equals(user))
        return true;
    }
    return false;
  }

  public int totalUsers()
  {
    return loginCredentials.size();
  }

  @Override public String addMsg(String user,String message)
  {
    messages.add(message);
    support.firePropertyChange("newMessage", null, new Msg(user,message));
    return message;
  }

  @Override public ArrayList<String> getAllUsers()
  {
    return userNames;
  }

  @Override public ArrayList<String> getAllMessages()
  {
    return messages;
  }

  @Override public Boolean addPrivateMessage(String user, String text)
  {
    privateMessages.add(text);
    support.firePropertyChange("privateMessage", null,text);

    for (int i = 0; i < userNames.size(); i++)
    {
      if(userNames.get(i).equals(user))
        return true;
    }
    return false;
  }

  @Override
  public ArrayList<String> getPrivateMessages()
  {
    return privateMessages;
  }

  @Override public void addPropertyChangeListener(String eventName, PropertyChangeListener listener)
  {
    if(eventName == null || eventName.equals(""))
      addPropertyChangeListener(listener);
    else
      support.addPropertyChangeListener(eventName,listener);
  }

  @Override public void addPropertyChangeListener(PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);
  }

  @Override public void removePropertyChangeListener(String eventName, PropertyChangeListener listener)
  {
    if(eventName ==null || eventName.equals(("")))
      removePropertyChangeListener(listener);
    else
      support.removePropertyChangeListener(eventName,listener);
  }

  @Override public void removePropertyChangeListener(PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(listener);
  }
}
