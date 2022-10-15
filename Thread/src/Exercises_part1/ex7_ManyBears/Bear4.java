package Exercises_part1.ex7_ManyBears;

public class Bear4 implements Runnable
{

  @Override public void run()
  {
    System.out.println("Bear4 is feeling tired");
    System.out.println("Bear4 goes to sleep");

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
