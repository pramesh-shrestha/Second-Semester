package client.clientNetwork;

import shared.Msg;
import shared.User;
import shared.network.ClientCallBack;
import shared.network.IRMIServer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class RMIClient implements Client, ClientCallBack
{
  private IRMIServer server;
  private PropertyChangeSupport support;

  public RMIClient()
  {
    support = new PropertyChangeSupport(this);
  }

  @Override
  public void startClient()
  {
    try
    {
      UnicastRemoteObject.exportObject(this,0);
      Registry registry = LocateRegistry.getRegistry("localhost", 1099);
      server = (IRMIServer) registry.lookup("Server");
      server.registerCallBack(this);
    }
    catch (RemoteException | NotBoundException e)
    {
      throw new RuntimeException(e);
    }

  }

  @Override
  public boolean login(String username, String password)
  {
    try
    {
      return server.login(username,password);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException(e);
    }

  }

  @Override
  public boolean checkUser(String user, String password)
  {
    try
    {
      boolean value = server.checkUser(user);
      if(value)
        server.addUser(new User(user,password));
      return value;
    }
    catch (RemoteException e)
    {
      throw new RuntimeException(e);
    }
  }

  @Override
  public String sendMessage(String user, String msg)
  {
    try
    {
      return server.addMsg(user, msg);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException(e);
    }
  }

  @Override
  public ArrayList<String> getAllUsers()
  {
    try
    {
      return server.getAllUsers();
    }
    catch (RemoteException e)
    {
      throw new RuntimeException(e);
    }
  }

  @Override
  public ArrayList<String> getAllText()
  {
    try
    {
      return server.getAllMessages();
    }
    catch (RemoteException e)
    {
      throw new RuntimeException(e);
    }
  }

  @Override
  public Boolean sendPrivateMessage(String userName, String msg)
  {
    try
    {
      return server.addPrivateMessage(userName,msg);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException(e);
    }
  }

  @Override
  public List<String> getAllPrivateMessages()
  {
    try
    {
      return server.getPrivateMessages();
    }
    catch (RemoteException e)
    {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void updateMessage(Msg msg)
  {
    support.firePropertyChange("newMessage", null, msg);
  }

  @Override
  public void updateUser(String user)
  {
    support.firePropertyChange("userLoggedIn", null, user);
  }

  @Override
  public void addPropertyChangeListener(String name, PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(name, listener);
  }

  @Override
  public void addPropertyChangeListener(PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);
  }

  @Override
  public void removePropertyChangeListener(String name, PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(name,listener);
  }

  @Override
  public void removePropertyChangeListener(PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);
  }


}
