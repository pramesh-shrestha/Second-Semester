package Exercises_part1.ex7_ManyBears;

public class Bear5 implements Runnable
{

  @Override public void run()
  {
    System.out.println("Bear5 is feeling tired");
    System.out.println("Bear5 goes to sleep");

    try
    {
      Thread.sleep(5000);
      System.out.println("Happy bear");

    }
    catch (InterruptedException e)
    {
      System.out.println("Man is walking");
      System.out.println("Man sees a bear, wishes to poke a bear");
      System.out.println("RIP");
    }
  }
}
