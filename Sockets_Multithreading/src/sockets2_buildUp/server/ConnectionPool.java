package sockets2_buildUp.server;

import sockets2_buildUp.util.Message;

import java.util.ArrayList;
import java.util.List;

public class ConnectionPool
{
  private List<SocketConnection> conns = new ArrayList<>();

  public void addClient(SocketConnection sc)
  {
    conns.add(sc);
  }

  public void removeClient(SocketConnection sc)
  {
    conns.remove(sc);
  }

  public void broadcast(Message message)
  {
    for(SocketConnection sc : conns)
    {
      sc.sendMessage(message);
    }
  }
}
