package Exercises_part1.ex7_ManyBears;

public class Bear3 implements Runnable
{

  @Override public void run()
  {
    System.out.println("Bear3 is feeling tired");
    System.out.println("Bear3 goes to sleep");

    try
    {
      Thread.sleep(5000);
      System.out.println("Happy bear");

    }
    catch (InterruptedException e)
    {
      System.out.println("Bear3 wakes up");

    }
  }
}
