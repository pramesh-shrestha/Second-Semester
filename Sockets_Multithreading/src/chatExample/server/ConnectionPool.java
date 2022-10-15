package chatExample.server;

import chatExample.shared.Message;

import java.util.ArrayList;
import java.util.List;

public class ConnectionPool
{
  private List<ServerSocketHandler> connections = new ArrayList<>();

  public void addConnection(ServerSocketHandler ssh)
  {
    connections.add(ssh);
  }

  public void broadcast(Message msg)
  {
    for(ServerSocketHandler conn : connections)
    {
      conn.sendMessageToClient(msg);
    }
  }
}
