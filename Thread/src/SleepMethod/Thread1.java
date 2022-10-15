package SleepMethod;

public class Thread1 implements Runnable
{
  @Override public void run()
  {

    for (int i = 1; i < 5; i++)
    {
      try
      {
        Thread.sleep(1000);
        System.out.println((char)(i +97));
      }
      catch (InterruptedException e)
      {
        throw new RuntimeException(e);
      }
    }

  }
}
