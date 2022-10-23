package client.clientModel;

import client.clientNetwork.Client;
import shared.Message;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class ClientModelManager implements ClientChatModel
{
  private Client client;
  private PropertyChangeSupport support;
  private ArrayList<String> users;

  public ClientModelManager(Client client)
  {
    this.client = client;
    users = new ArrayList<>();
    support = new PropertyChangeSupport(this);
    client.startClient();
    client.addPropertyChangeListener("userLoggedIn", this::onNewLogin);
    client.addPropertyChangeListener("newMessage", this::onNewMessage);
    client.addPropertyChangeListener("privateMessage", this::onPrivateMessage);

    //todo this must be added as a listener who listens to new user, and whenerver new user is added
    //it fires notification an forwards the event up the layer
  }

  private void onPrivateMessage(PropertyChangeEvent event)
  {
    support.firePropertyChange(event);
  }

  private void onNewMessage(PropertyChangeEvent event)
  {
    support.firePropertyChange(event);
  }

  private void onNewLogin(PropertyChangeEvent event)
  {
    support.firePropertyChange(event);
  }



  @Override
  public Boolean login(String username, String password)
  {
    users.add(username);
    return client.login(username, password);
  }

  @Override
  public Boolean checkUsername(String user, String password)
  {
    return client.checkUser(user,password);
  }

  @Override public String sendMessage(String user,String msg)
  {
    return client.sendMessage(user,msg);
  }

  //get all the usernames from the server
  @Override
  public ArrayList<String > getAllUsername ()
  {
  return client.getAllUsers();
  }

  //get all the messages from the server
  @Override
  public ArrayList<String > getAllMessages ()
  {
    return client.getAllText();
  }

  @Override public Boolean sendPrivateMessage(String userName, String msg)
  {
    return client.sendPrivateMessage(userName,msg);
  }

  //for private message
  @Override public List<String> getAllPrivateMessages()
  {
    return client.getAllPrivateMessages();
  }

  @Override
  public void addPropertyChangeListener(String eventName, PropertyChangeListener listener)
  {
    if(eventName == null || eventName.equals(""))
      addPropertyChangeListener(listener);
    else
      support.addPropertyChangeListener(eventName,listener);
  }

  @Override
  public void addPropertyChangeListener(PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);
  }

  @Override
  public void removePropertyChangeListener(String eventName, PropertyChangeListener listener)
  {
    if(eventName ==null || eventName.equals(("")))
      removePropertyChangeListener(listener);
    else
      support.removePropertyChangeListener(eventName,listener);
  }

  @Override
  public void removePropertyChangeListener(PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(listener);
  }
}
