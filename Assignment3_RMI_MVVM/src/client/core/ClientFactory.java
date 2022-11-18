package client.core;

import client.clientNetwork.Client;
import client.clientNetwork.RMIClient;

public class ClientFactory
{
  private Client client;

  public ClientFactory()
  {
    client = new RMIClient();
  }

  public Client getClient()
  {
    return client;
  }
}
