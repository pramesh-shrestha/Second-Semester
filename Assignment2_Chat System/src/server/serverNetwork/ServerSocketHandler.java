package server.serverNetwork;

import server.serverModel.ServerChatModel;
import shared.Msg;
import shared.Request;
import shared.User;

import java.beans.PropertyChangeEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ServerSocketHandler implements Runnable
{
  private Socket socket;
  private ObjectInputStream inFromClient;
  private ObjectOutputStream outToClient;
  private ServerChatModel serverChatModel;
  private ConnectionPool pool;


  public ServerSocketHandler(Socket socket, ServerChatModel serverChatModel, ConnectionPool pool)
  {
    this.socket = socket;
    this.pool = pool;
    this.serverChatModel = serverChatModel;

    try
    {
      inFromClient = new ObjectInputStream(socket.getInputStream());
      outToClient = new ObjectOutputStream(socket.getOutputStream());
    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }
  }
  @Override
  public void run()
  {
    try
    {
      Request request = (Request) inFromClient.readObject();
      if(request.getType().equals("Listener"))
      {
        serverChatModel.addPropertyChangeListener("userLoggedIn", this::onNewLogin);
        serverChatModel.addPropertyChangeListener("newMessage", this::onNewMessage);
        serverChatModel.addPropertyChangeListener("privateMessage", this::onPrivateMessage);
      }
      else if(request.getType().equals("checkUser"))
      {
        User user = (User) request.getArg();
        if(!serverChatModel.checkUser(user.getUsername()))
        {
          serverChatModel.addUser(user);
          outToClient.writeObject(new Request("checkUser",false));
        }
        else
        {
          outToClient.writeObject(new Request("checkUser",true));
        }
      }
      else if(request.getType().equals("login"))
      {
        User user = (User) request.getArg();
        if(serverChatModel.login(user.getUsername(), user.getPassword()))
        {
          outToClient.writeObject(new Request("login", true));
        }
        else {
          outToClient.writeObject(new Request("login", false));
        }
      }
      else if(request.getType().equals("message"))
      {
        Msg message = (Msg) request.getArg();
        String msg = serverChatModel.addMsg(message.getUser(),message.getText());
        outToClient.writeObject(new Request("newMessage",msg));
      }
      else if (request.getType().equals("getAllUsers"))
      {
        ArrayList <String> list = serverChatModel.getAllUsers();
        outToClient.writeObject(new Request("getAllUsers",list));
      }
      else if(request.getType().equals("getAllMessages"))
      {
        ArrayList<String> list = serverChatModel.getAllMessages();
        outToClient.writeObject(new Request("getAllMessages", list));
      }
      else if(request.getType().equals("privateMessage"))
      {
        Msg message = (Msg) request.getArg();
        Boolean value = serverChatModel.addPrivateMessage(message.getUser(),message.getText());
        outToClient.writeObject(new Request("privateMessage", value));
      }
      else if(request.getType().equals("getPrivateMessages"))
      {
        ArrayList<String> list = serverChatModel.getPrivateMessages();
        outToClient.writeObject(new Request("getPrivateMessages", list));
      }
    }
    catch (IOException | ClassNotFoundException e)
    {
      throw new RuntimeException(e);
    }

  }

  private void onPrivateMessage(PropertyChangeEvent event)
  {
    try
    {
      outToClient.writeObject(new Request(event.getPropertyName(),event.getNewValue()));
    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }
  }

  private void onNewMessage(PropertyChangeEvent event)
  {
    try
    {
      outToClient.writeObject(new Request(event.getPropertyName(),event.getNewValue()));
    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }
  }

  private void onNewLogin(PropertyChangeEvent evt)
  {
    try {
      outToClient.writeObject(new Request(evt.getPropertyName(), evt.getNewValue()));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  //sending message to the clients
  public void sendMessage(Request request)
  {
    try
    {
      outToClient.writeObject(request);
    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }
  }
}
