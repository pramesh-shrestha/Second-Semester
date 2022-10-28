package ex3_MultipleBridges.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ClientMain
{
  public static void main(String[] args) throws NotBoundException, RemoteException
  {
    RemoteClient client = new RemoteClient();
    client.changeToRandomCase("Pramesh");
    client.changeToUpperCase("pramesh");
  }
}
