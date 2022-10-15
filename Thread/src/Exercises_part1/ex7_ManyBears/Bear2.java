package Exercises_part1.ex7_ManyBears;

public class Bear2 implements Runnable
{
//  private Thread bear1;
//
//  public Bear2(Thread bear1)
//  {
//    this.bear1 = bear1;
//  }

  @Override public void run()
  {
    System.out.println("Bear2 is feeling tired");
    System.out.println("Bear2 goes to sleep");

    try
    {
      Thread.sleep(5000);
      System.out.println("Happy bear");

    }
    catch (InterruptedException e)
    {
      System.out.println("Bear2 wakes up");
    }
  }
}
