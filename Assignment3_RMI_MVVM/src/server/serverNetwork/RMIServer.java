package server.serverNetwork;

import server.serverModel.ServerChatModel;
import shared.Msg;
import shared.User;
import shared.network.ClientCallBack;
import shared.network.IRMIServer;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RMIServer implements IRMIServer
{
  private ServerChatModel serverChatModel;

  public RMIServer(ServerChatModel serverChatModel) throws RemoteException
  {
    this.serverChatModel = serverChatModel;
    UnicastRemoteObject.exportObject(this,0);
  }

  public void startServer() throws RemoteException, AlreadyBoundException
  {
    Registry registry = LocateRegistry.createRegistry(1099);
    registry.bind("Server", this);
  }

  @Override
  public void addUser(User user)
  {
    serverChatModel.addUser(user);
  }

  @Override
  public boolean login(String username, String password)
  {
    return serverChatModel.login(username,password);
  }

  @Override
  public boolean checkUser(String user)
  {
    return serverChatModel.checkUser(user);
  }

  @Override
  public String addMsg(String user, String message)
  {
    return serverChatModel.addMsg(user, message);
  }

  @Override
  public ArrayList<String> getAllUsers()
  {
    return serverChatModel.getAllUsers();
  }

  @Override
  public ArrayList<String> getAllMessages()
  {
    return serverChatModel.getAllMessages();
  }

  @Override
  public Boolean addPrivateMessage(String user, String text)
  {
    return serverChatModel.addPrivateMessage(user, text);
  }

  @Override
  public ArrayList<String> getPrivateMessages()
  {
    return serverChatModel.getPrivateMessages();
  }

  @Override
  public void registerCallBack(ClientCallBack ccb)
  {
    serverChatModel.addPropertyChangeListener("userLoggedIn", evt -> {
      try
      {
        ccb.updateUser((String) evt.getNewValue());
      }
      catch (Exception e)
      {
        throw new RuntimeException(e);
      }
    });

    serverChatModel.addPropertyChangeListener("newMessage", evt -> {
      try
      {
        ccb.updateMessage((Msg) evt.getNewValue());
      }
      catch (Exception e)
      {
        throw new RuntimeException(e);
      }
    });
  }

}
