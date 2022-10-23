package server;

import server.serverModel.ServerChatModelManager;
import server.serverNetwork.SocketServer;

public class RunServer
{
  public static void main(String[] args)
  {
    ServerChatModelManager serverChatModelManager = new ServerChatModelManager();
    SocketServer server = new SocketServer(serverChatModelManager);
    server.startServer();

  }

}
