package RMI.server;



import RMI.shared.UpperCaseClient;
import RMI.shared.UpperCaseServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ServerImpl implements UpperCaseServer {
    private int grade;

    private List<UpperCaseClient> broadcastClients = new ArrayList<>();

    public ServerImpl(){
        try {
            UnicastRemoteObject.exportObject(this, 0);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toUpperCase(String arg, UpperCaseClient client) {
        String result =  arg.toUpperCase();
//        try {
//            client.update(result);
//        }
//        catch (RemoteException e) {
//            e.printStackTrace();
//        }

        broadcastToClients(result, client);

        return result;
    }

    private void broadcastToClients(String arg, UpperCaseClient client){
        for (UpperCaseClient bClient : broadcastClients) {
            if(!bClient.equals(client)){
                try {
                    bClient.update(arg);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void registerClient(UpperCaseClient client) {
        broadcastClients.add(client);
    }

    public String asd(){
       ;

        if(grade >= 50){
            return "Passed";
        } else{
            return "Failed";
        }
    }
}
