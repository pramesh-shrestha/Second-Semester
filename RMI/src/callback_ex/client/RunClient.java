package callback_ex.client;

import java.rmi.RemoteException;
import java.util.Scanner;

public class RunClient {
    public static void main(String[] args) throws RemoteException {

        ClientImpl client = new ClientImpl();
        client.initializeConnection(); //get access to the server

        Scanner scan = new Scanner(System.in);
        String read = "";

        while(true){
            System.out.println("Input >");
            read = scan.nextLine();
            if(read.equalsIgnoreCase("exit")) break;

            client.toUpperCase(read); //call server + the server calls client back
        }

    }
}
