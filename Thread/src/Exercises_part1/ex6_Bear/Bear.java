package Exercises_part1.ex6_Bear;

public class Bear implements Runnable
{

  @Override public void run()
  {


    try
    {
      System.out.println("Bear is feeling tired");
      System.out.println("Bear goes to sleep");
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
