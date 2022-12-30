package uppercase.server;


import uppercase.server.model.TextManagerImpl;
import uppercase.server.networking.RMIServerImpl;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

public class RunServer {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException
    {

        RMIServerImpl server = new RMIServerImpl(new TextManagerImpl());
        server.startServer();
    }
}
