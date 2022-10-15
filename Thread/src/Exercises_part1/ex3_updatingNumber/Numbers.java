package Exercises_part1.ex3_updatingNumber;

public class Numbers implements Runnable
{
  private int numberThread;

  public Numbers(int numberThread)
  {
    this.numberThread = numberThread;
  }
  public void run()
  {
    for (int i = 0; i < numberThread; i++)
      System.out.println(i);
  }
}
