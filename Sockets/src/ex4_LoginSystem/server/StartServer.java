package ex4_LoginSystem.server;

public class StartServer
{
  public static void main(String[] args)
  {
    EchoServer echoServer = new EchoServer();
    echoServer.startServer();
  }
}
