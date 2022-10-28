package nastava.rmi1.funcionallity_ex.server;

import nastava.rmi1.funcionallity_ex.shared.LowerCaseServer;
import nastava.rmi1.funcionallity_ex.shared.Server;
import nastava.rmi1.funcionallity_ex.shared.UpperCaseServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerImpl implements Server {

    public ServerImpl(){
        try {
            UnicastRemoteObject.exportObject(this, 1099);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public LowerCaseServer getLowerCase(){
        try {
            return new LowerCaseServerImpl();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public UpperCaseServer getUpperCase() {
        try {
            return new UpperCaseServerImpl();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }
}
