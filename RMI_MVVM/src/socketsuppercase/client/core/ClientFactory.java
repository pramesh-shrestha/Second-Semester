package socketsuppercase.client.core;

import socketsuppercase.client.network.Client;
import socketsuppercase.client.network.RMIClient;


public class ClientFactory {

    private Client client;

    public Client getClient() {
        if(client == null) {
            client = new RMIClient();
        }
        return client;
    }
}
