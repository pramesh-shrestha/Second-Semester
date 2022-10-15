package simpleChat.server;

import java.util.ArrayList;
import java.util.List;

public class ConnectionPool
{
  private List<ServerSocketHandler> connections;

  public ConnectionPool()
  {
    connections = new ArrayList<>();
  }

  public void addConnections(ServerSocketHandler ssh)
  {
    connections.add(ssh);
  }

  public void broadcastMessage(String msg)
  {
    for(ServerSocketHandler ssh : connections)
    {
      ssh.sendMessage(msg);
    }
  }

}
