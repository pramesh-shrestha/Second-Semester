package UpperCase.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IUppercaseServer extends Remote
{
  String toUppercase(String str) throws RemoteException;
}
