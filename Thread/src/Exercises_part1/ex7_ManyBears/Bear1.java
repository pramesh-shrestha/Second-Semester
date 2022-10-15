package Exercises_part1.ex7_ManyBears;

public class Bear1 implements Runnable
{
  private Thread bear2;
  private Thread bear3;
  private Thread bear4;
  private Thread bear5;

  @Override public void run()
  {
    System.out.println("Bear1 is feeling tired");
    System.out.println("Bear1 goes to sleep");

    try
    {
      Thread.sleep(5000);
      System.out.println("Happy bear");

    }
    catch (InterruptedException e)
    {
      System.out.println("Man is walking");
      System.out.println("Man sees a bear, wishes to poke a bear");
      System.out.println("Bear1 wakes up");
      bear2.interrupt();
      bear3.interrupt();

      System.out.println("RIP");
    }
  }
}
