package nastava.rmi1.funcionallity_ex.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface LowerCaseServer extends Remote {

    String toLowerCase(String arg) throws RemoteException;
}
