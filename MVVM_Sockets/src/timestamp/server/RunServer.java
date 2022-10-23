package timestamp.server;


import timestamp.server.model.DataModelManager;
import timestamp.server.networking.SocketServer;

public class RunServer
{
    public static void main(String[] args) {

        SocketServer ss = new SocketServer(new DataModelManager());
        ss.startServer();
    }
}
