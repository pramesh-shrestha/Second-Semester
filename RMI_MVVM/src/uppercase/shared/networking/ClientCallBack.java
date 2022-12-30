package uppercase.shared.networking;

import uppercase.shared.transferobjects.LogEntry;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientCallBack extends Remote
{
  void update(LogEntry entry) throws RemoteException;
}
