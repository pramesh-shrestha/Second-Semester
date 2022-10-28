package nastava.rmi1.boradcast_ex.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UpperCaseClient extends Remote {

    void update(String arg) throws RemoteException;
}
