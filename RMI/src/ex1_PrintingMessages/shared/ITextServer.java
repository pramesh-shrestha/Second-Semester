package ex1_PrintingMessages.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ITextServer extends Remote
{
  void printText(String text) throws RemoteException;
}
