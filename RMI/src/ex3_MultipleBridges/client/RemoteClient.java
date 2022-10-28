package ex3_MultipleBridges.client;

import ex3_MultipleBridges.server.ToRandomCase;
import ex3_MultipleBridges.server.ToUpperCase;
import ex3_MultipleBridges.shared.IStringChangingServer;
import ex3_MultipleBridges.shared.IToRandomCase;
import ex3_MultipleBridges.shared.IToUpperCase;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RemoteClient
{
 private IStringChangingServer stringChangingServer;

 public RemoteClient() throws RemoteException, NotBoundException
 {
  Registry registry = LocateRegistry.getRegistry("localhost", 1099);
  stringChangingServer = (IStringChangingServer) registry.lookup("StringChangingServer");
 }

 public void changeToUpperCase(String arg) throws RemoteException
 {
  //We must cast it because stringChangingServer.getUpperCase() gives IToUppercase
  IToUpperCase upperCase = (IToUpperCase) stringChangingServer.getUpperCase();
  String result = upperCase.toUppercase(arg);
  System.out.println("Uppercase > " + result);
 }

 public void changeToRandomCase(String arg) throws RemoteException
 {
  IToRandomCase randomCase = (IToRandomCase) stringChangingServer.getRandomCase();
  String result = randomCase.toRandomCase(arg);
  System.out.println("Random case > " + result);
 }

}
