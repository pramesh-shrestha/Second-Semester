package timestamp.client.network;



import timestamp.shared.Request;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SocketClient implements Client
{
  private PropertyChangeSupport support;

  public SocketClient() {
    support = new PropertyChangeSupport(this);
  }

  @Override public void startClient()
  {
    try
    {
      Socket socket = new Socket("localhost",6000);
      ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
      ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());

      new Thread(() -> listenToServer(outToServer, inFromServer)).start();
    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }
  }
  private void listenToServer(ObjectOutputStream outToServer, ObjectInputStream inFromServer)
  {
    try
    {
      outToServer.writeObject(new Request("Listener", null));
      while (true) {
        Request request = (Request) inFromServer.readObject();
        support.firePropertyChange(request.getType(), null, request.getArg());
      }
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
  }


  @Override
  public String getLastUpdateTimeStamp()
  {
    try
    {
      Request response = request("getLastUpdateTimeStamp", null);
      return (String) response.getArg();
    }
    catch (IOException | ClassNotFoundException e)
    {
      throw new RuntimeException(e);
    }
  }

  @Override
  public int getNumberOfUpdates()
  {
    try
    {
      Request response = request("getNumberOfUpdates", null);
      return (int)response.getArg();
    }
    catch (IOException | ClassNotFoundException e)
    {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void setTimeStamp(Date timeStamp)
  {
    try
    {
      Request response = request("SetTimeStamp", timeStamp);



    }
    catch (IOException | ClassNotFoundException e)
    {
      throw new RuntimeException(e);
    }
  }

private Request request(String type, Object arg) throws IOException, ClassNotFoundException
{
  Socket socket = new Socket("localhost", 6000);
  ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
  ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());
  outToServer.writeObject(new Request(type,arg));
  return (Request) inFromServer.readObject();
}

  @Override
  public void addPropertyChangeListener(String name, PropertyChangeListener listener)
  {
    if(name.equals("") || name == null)
      addPropertyChangeListener(listener);
    else
      support.addPropertyChangeListener(name, listener);
  }

  @Override
  public void addPropertyChangeListener(PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);
  }

  @Override
  public void removePropertyChangeListener(String name, PropertyChangeListener listener)
  {
    if(name.equals("") || name == null)
      removePropertyChangeListener(listener);
    else
      support.removePropertyChangeListener(name, listener);
  }

  @Override
  public void removePropertyChangeListener(PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(listener);
  }




}
