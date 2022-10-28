package client.clientNetwork;

import shared.Msg;
import shared.Request;
import shared.User;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SocketClient implements Client
{

  private PropertyChangeSupport support;

  public SocketClient ()
  {
    support = new PropertyChangeSupport(this);
  }

  //start Client
  @Override public void startClient()
  {
    try {
      Socket socket = new Socket("localhost", 2910);
      ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
      ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());
        new Thread(() -> listenToServer(outToServer, inFromServer)).start();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void listenToServer(ObjectOutputStream outToServer, ObjectInputStream inFromServer) {
    try {
      outToServer.writeObject(new Request("Listener", null));
      while (true) {
        Request request = (Request) inFromServer.readObject();
        support.firePropertyChange(request.getType(), null, request.getArg());
      }
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

//check if login credentials match and then log the user in
  @Override public Boolean login(String username, String password)
  {
    Boolean bool = false;
    try
    {
      Request response = request("login", new User(username,password));
      bool = (Boolean) response.getArg();
    }
    catch (IOException | ClassNotFoundException e)
    {
      throw new RuntimeException(e);
    }
    return  bool;
  }

  //check if the user exist and then add the user to the server
  @Override public Boolean checkUser(String user,String password)
  {
    Boolean bool = false;
    try {
      Request response = request("checkUser", new User(user,password));
      bool =  (Boolean) response.getArg();

    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
    return bool;
  }

  //send message to other client
  @Override public String sendMessage(String user,String msg)
  {
    try
    {
      Request response = request("message", new Msg(user,msg));
      String message = (String) response.getArg();
      return message;

    }
    catch (IOException | ClassNotFoundException e)
    {
      throw new RuntimeException(e);
    }
  }

  @Override public ArrayList<String> getAllUsers()
  {
    try
    {
      Request response = request("getAllUsers",null);
      return (ArrayList<String>) response.getArg();
    }
    catch (IOException | ClassNotFoundException e)
    {
      throw new RuntimeException(e);
    }
  }

  //all message from the server
  @Override public ArrayList<String> getAllText()
  {
    try
    {
      Request response = request("getAllMessages", null);
      return (ArrayList<String>) response.getArg();
    }
    catch (IOException | ClassNotFoundException e)
    {
      throw new RuntimeException(e);
    }
  }

  //private message
  @Override public Boolean sendPrivateMessage(String userName, String msg)
  {
    try
    {
      Request response = request("privateMessage",new Msg(userName, msg));
      return (Boolean) response.getArg();
    }
    catch (IOException | ClassNotFoundException e)
    {
      throw new RuntimeException(e);
    }
  }

  //private message
  @Override public List<String> getAllPrivateMessages()
  {
    try
    {
      Request response = request("getPrivateMessages", null);
      return (ArrayList<String>) response.getArg();
    }
    catch (IOException | ClassNotFoundException e)
    {
      throw new RuntimeException(e);
    }
  }

  private Request request(String type, Object arg) throws IOException, ClassNotFoundException {
    Socket socket = new Socket("localhost", 2910);
    ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
    ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());
    outToServer.writeObject(new Request(type, arg));
    return (Request) inFromServer.readObject();
  }

  @Override public void addPropertyChangeListener(String eventName, PropertyChangeListener listener)
  {
    if(eventName == null || eventName.equals(""))
      addPropertyChangeListener(listener);
    else
      support.addPropertyChangeListener(eventName,listener);
  }

  @Override public void addPropertyChangeListener(PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);
  }

  @Override public void removePropertyChangeListener(String eventName, PropertyChangeListener listener)
  {
    if(eventName ==null || eventName.equals(("")))
      removePropertyChangeListener(listener);
    else
      support.removePropertyChangeListener(eventName,listener);
  }

  @Override public void removePropertyChangeListener(PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(listener);
  }
}
