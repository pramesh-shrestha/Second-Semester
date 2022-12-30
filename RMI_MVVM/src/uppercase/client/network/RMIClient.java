package uppercase.client.network;

import uppercase.shared.networking.ClientCallBack;
import uppercase.shared.networking.RMIServer;
import uppercase.shared.transferobjects.LogEntry;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class RMIClient implements ClientCallBack, Client
{
  private RMIServer server;
  private PropertyChangeSupport support;
  public RMIClient()
  {
    support = new PropertyChangeSupport(this);
  }

  @Override public void startClient()
  {
    try
    {
      UnicastRemoteObject.exportObject(this,0);
      Registry registry = LocateRegistry.getRegistry("localhost", 1099);
      server = (RMIServer) registry.lookup("UpperCaseServer");
      server.registerCallBack(this);
    }
    catch (RemoteException | NotBoundException e)
    {
      throw new RuntimeException(e);
    }
  }

  @Override public String toUpperCase(String str)
  {
    try
    {
      return server.toUpperCase(str);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException(e);
    }
  }

  @Override public List<LogEntry> getLog()
  {
    try
    {
      return server.getLogs();
    }
    catch (RemoteException e)
    {
      throw new RuntimeException(e);
    }
  }



  @Override public void update(LogEntry entry) throws RemoteException
  {
    support.firePropertyChange("NewLogEntry", null, entry);
  }

  @Override public void addListener(String eventName, PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(eventName,listener);
  }

  @Override public void removeListener(String eventName, PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(eventName,listener);
  }
}
