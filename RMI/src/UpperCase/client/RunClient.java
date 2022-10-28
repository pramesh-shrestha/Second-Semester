package UpperCase.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class RunClient
{
  public static void main(String[] args) throws NotBoundException, RemoteException
  {
    Client client = new Client();
    client.startClient();

    Scanner input  = new Scanner(System.in);
    String read = "";
    while(!read.equalsIgnoreCase("exit"))
    {
      System.out.println("Input >");
      read = input.nextLine();
      if(read.equalsIgnoreCase("exit")) break;

      String  result = client.toUppercase(read);
      System.out.println("Result > " + result);

    }
  }
}
