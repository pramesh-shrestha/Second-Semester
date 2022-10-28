package ex2_Echo.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ClientMain
{
  public static void main(String[] args) throws NotBoundException, RemoteException
  {
    EchoClient client = new EchoClient();
    client.addMessage("Hello");
  }
}
