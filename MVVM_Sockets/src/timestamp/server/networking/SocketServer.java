package timestamp.server.networking;

import timestamp.server.model.DataModel;
import timestamp.server.model.DataModelManager;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer
{
  private DataModel dataModel;

  public SocketServer()
  {
    dataModel = new DataModelManager();
  }

  public void startServer()
  {
    try
    {
      ServerSocket serverSocket = new ServerSocket(2910);
      while(true)
      {
        Socket socket = serverSocket.accept();
        new Thread(() -> new ServerSocketHandler(socket,dataModel));
      }
    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }
  }


}
