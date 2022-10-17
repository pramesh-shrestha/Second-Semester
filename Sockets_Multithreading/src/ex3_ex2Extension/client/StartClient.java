package ex3_ex2Extension.client;

public class StartClient
{
  public static void main(String[] args)
  {
    Thread incrementThread = new Thread(new IncrementClient());
    Thread decrementThread = new Thread(new DecrementClient());

    incrementThread.start();
    decrementThread.start();
  }
}
