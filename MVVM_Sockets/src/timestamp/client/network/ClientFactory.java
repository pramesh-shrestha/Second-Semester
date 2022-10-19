package timestamp.client.network;

public class ClientFactory
{
  private Client client;

  public ClientFactory()
  {
    client = new SocketClient();
  }

  public Client getClient()
  {
    return client;
  }
}
