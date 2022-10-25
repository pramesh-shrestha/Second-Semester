package timestamp.server.client.network;

public class ClientFactory
{
  private Client client;

  public Client getClient()
  {
    if(client == null)
    {
      client = new SocketClient();
    }
    return client;
  }
}
