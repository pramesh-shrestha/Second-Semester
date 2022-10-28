package nastava.rmi1.funcionallity_ex.server;

import nastava.rmi1.funcionallity_ex.shared.LowerCaseServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Locale;

public class LowerCaseServerImpl implements LowerCaseServer {

    public LowerCaseServerImpl() throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);
    }

    @Override
    public String toLowerCase(String arg) {
        return arg.toLowerCase(Locale.ROOT);
    }
}
