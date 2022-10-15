package SleepMethod;

public class RunThread
{
  public static void main(String[] args)
  {
    System.out.println("Start");
    Thread thread1 = new Thread(new Thread1());
    thread1.start();

    Thread thread2 = new Thread(new Thread2());
    thread2.start();
    try
    {
      Thread.sleep(7000);
      System.out.println("The End");
    }
    catch (InterruptedException e)
    {
      throw new RuntimeException(e);
    }



  }
}
