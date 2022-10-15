package InterruptMethod;

public class Test implements Runnable
{
  @Override public void run()
  {
    try
      {
        for (int i = 1; i < 5; i++)
        {
          System.out.println(i);
          Thread.sleep(1000);
        }
      }
      catch (InterruptedException e)
      {
        System.out.println("Thread interrupted: " + e);

      }

  }

  public static void main(String[] args)
  {
    Thread thread = new Thread(new Test());
    thread.start();
    thread.interrupt();
  }
}
