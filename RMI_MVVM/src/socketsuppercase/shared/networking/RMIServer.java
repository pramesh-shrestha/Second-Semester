package socketsuppercase.shared.networking;

import socketsuppercase.shared.transferobjects.LogEntry;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface RMIServer extends Remote
{
  String toUpperCase(String str) throws RemoteException;
  List<LogEntry> getLogs() throws RemoteException;
  void registerCallBack(ClientCallBack ccb) throws RemoteException;
}
