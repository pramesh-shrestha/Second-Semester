package nastava.rmi1.funcionallity_ex.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Server extends Remote {
    LowerCaseServer getLowerCase() throws RemoteException;
    UpperCaseServer getUpperCase() throws RemoteException;

}
