package Exercises_part2.ex3_Mailbox;

public class Mailbox implements Runnable
{
  private long maxFrequency;
  private int count;
  private static long RUNTIME = 100000;

  public Mailbox(int count)
  {
    this.count = count;
  }

  @Override public void run()
  {
    for (int i = 0; i < count; i++)
    {
      System.out.println("New mailbox in your inbox.");
    }

  }

}
