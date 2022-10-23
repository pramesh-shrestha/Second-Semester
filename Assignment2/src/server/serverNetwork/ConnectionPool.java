package server.serverNetwork;

import shared.Message;
import shared.Request;

import java.util.ArrayList;
import java.util.List;

public class ConnectionPool
{
  private List<ServerSocketHandler> connections;

  public ConnectionPool()
  {
    connections = new ArrayList<>();
  }

  //broadcast message to all the clients connected
  public void broadcast(String msg)
  {
    Request request = new Request("message", msg);
    for(ServerSocketHandler ssh : connections)
    {
      ssh.sendMessage(request);
    }
  }

  public synchronized void addConnections(ServerSocketHandler ssh)
  {
    connections.add(ssh);
  }

  public List<ServerSocketHandler> getConnections()
  {
    return connections;
  }
}
