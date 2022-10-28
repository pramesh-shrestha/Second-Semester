package ex1_PrintingMessages.server;

import ex1_PrintingMessages.shared.ITextServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMITextServer implements ITextServer
{
  public RMITextServer() throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
  }

  @Override
  public void printText(String text) throws RemoteException
  {
    System.out.println(text);
  }
}
