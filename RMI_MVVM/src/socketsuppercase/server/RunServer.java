package socketsuppercase.server;


import socketsuppercase.server.model.TextManagerImpl;
import socketsuppercase.server.networking.RMIServerImpl;

import java.rmi.RemoteException;

public class RunServer {
    public static void main(String[] args) throws RemoteException
    {

        RMIServerImpl server = new RMIServerImpl(new TextManagerImpl());
        server.startServer();
    }
}
