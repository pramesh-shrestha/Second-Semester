package timestamp.server.networking;

import timestamp.server.model.DataModel;
import timestamp.server.model.DataModelManager;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer
{
  private DataModel dataModel;

  public SocketServer(DataModel dataModel)
  {
    this.dataModel = dataModel;
  }

  public void startServer()
  {
    try
    {
      System.out.println("Server started..");
      ServerSocket serverSocket = new ServerSocket(6000);
      while(true)
      {
        Socket socket = serverSocket.accept();
        System.out.println("connected");
        ServerSocketHandler ssh = new ServerSocketHandler(socket,dataModel);
        Thread thread = new Thread(ssh);
        thread.start();
      }
    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }
  }


}
