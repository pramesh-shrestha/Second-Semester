package uppercase.server.networking;

import uppercase.server.model.TextManager;
import uppercase.shared.networking.ClientCallBack;
import uppercase.shared.networking.RMIServer;
import uppercase.shared.transferobjects.LogEntry;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class RMIServerImpl implements RMIServer
{
  private TextManager textManager;

  public RMIServerImpl(TextManager textManager) throws RemoteException
  {
    this.textManager = textManager;
    UnicastRemoteObject.exportObject(this,0);
  }

  public void startServer() throws RemoteException, AlreadyBoundException
  {
    Registry registry = LocateRegistry.createRegistry(1099);
    registry.bind("UpperCaseServer", this);
  }

  @Override public String toUpperCase(String str)
  {
    return textManager.toUppercase(str);
  }

  @Override public List<LogEntry> getLogs()
  {
    return textManager.getLog();
  }

  @Override public void registerCallBack(ClientCallBack ccb)
  {
    textManager.addListener("NewLogEntry", evt -> {
      try
      {
        ccb.update((LogEntry) evt.getNewValue());
      }
      catch (RemoteException e)
      {
        e.printStackTrace();
      }
    });
  }
}
