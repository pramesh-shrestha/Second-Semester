package SleepMethod;

public class SleepMethod implements Runnable
{

  @Override public void run()
  {
    for (int i = 1; i < 5; i++)
    {
      System.out.println(i);
      try
      {
        Thread.sleep(1000);
      }
      catch (InterruptedException e)
      {
        throw new RuntimeException(e);
      }

    }
  }

  public static void main(String[] args)
  {
    Thread firstThread = new Thread(new SleepMethod());
    firstThread.start();

    Thread secondThread = new Thread(new SleepMethod());
    secondThread.start();

  }


}
