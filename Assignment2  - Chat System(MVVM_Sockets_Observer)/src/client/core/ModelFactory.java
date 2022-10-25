package client.core;

import client.clientModel.ClientChatModel;
import client.clientModel.ClientModelManager;

public class ModelFactory
{
  private ClientFactory clientFactory;
  private ClientChatModel clientChatModel;

  public ModelFactory(ClientFactory clientFactory)
  {
    this.clientFactory = clientFactory;
    clientChatModel = new ClientModelManager(clientFactory.getClient());
  }

  public ClientFactory getClientFactory()
  {
    return clientFactory;
  }

  public ClientChatModel getClientChatModel()
  {
    return clientChatModel;
  }
}
