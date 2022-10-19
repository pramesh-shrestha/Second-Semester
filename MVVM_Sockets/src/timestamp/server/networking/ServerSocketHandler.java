package timestamp.server.networking;

import timestamp.server.model.DataModel;
import timestamp.shared.Request;

import java.beans.PropertyChangeEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerSocketHandler implements Runnable
{
  private Socket socket;
  private DataModel dataModel;
  private ObjectInputStream inFromClient;
  private ObjectOutputStream outToClient;

  public ServerSocketHandler(Socket socket, DataModel dataModel)
  {
    this.socket = socket;
    this.dataModel = dataModel;
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

  @Override public void run()
  {
    try
    {
      Request request = (Request) inFromClient.readObject();
      if ("Listener".equals(request.getType()))
      {
        dataModel.addPropertyChangeListener("updated", this::onUpdated);
      }
      else if("getLastUpdateTimeStamp".equals(request.getType()))
      {
        String result = dataModel.getLastUpdateTimeStamp();
        outToClient.writeObject(new Request("getLastUpdateTimeStamp", result));
      }
      else if("getNumberOfUpdates".equals(request.getType()))
      {
        int result = dataModel.getNumberOfUpdates();
        outToClient.writeObject(new Request("getNumberOfUpdates", result));
      }
      else if("SetTimeStamp".equals(request.getType()))
      {
        //todo implement settimestamp
      }
    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }
    catch (ClassNotFoundException e)
    {
      throw new RuntimeException(e);
    }
  }

  private void onUpdated(PropertyChangeEvent event)
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
}
