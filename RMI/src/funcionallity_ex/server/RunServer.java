package funcionallity_ex.server;

import boradcast_ex.server.ServerImpl;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RunServer {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        System.out.println("Server up");
        ServerImpl server = new ServerImpl();
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.bind("Server", server);

    }
}
