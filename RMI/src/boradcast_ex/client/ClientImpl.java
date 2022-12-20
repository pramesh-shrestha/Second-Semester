package boradcast_ex.client;

import boradcast_ex.shared.UpperCaseClient;
import boradcast_ex.shared.UpperCaseServer;


import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ClientImpl implements UpperCaseClient {

    private UpperCaseServer server;

    public ClientImpl() throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);
    }

    public void initializeConnection(){
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            server = (UpperCaseServer) registry.lookup("Server");
            //register client
            server.registerClient(this);
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }

    public String toUpperCase(String arg){
        String result = "";
        try {
            result = server.toUpperCase(arg, this);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void update(String arg) throws RemoteException {
        System.out.println("Broadcast > "+ arg);
    }
}
