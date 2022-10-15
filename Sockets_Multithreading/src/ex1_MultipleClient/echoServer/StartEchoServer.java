package ex1_MultipleClient.echoServer;

public class StartEchoServer
{
  public static void main(String[] args)
  {
    EchoServer echoServer = new EchoServer();
    echoServer.startServer();
  }
}
