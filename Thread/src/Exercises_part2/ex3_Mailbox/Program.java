package Exercises_part2.ex3_Mailbox;

public class Program implements Runnable
{
  private String program;
  private long maxFrequency;
  private String action;
  private int count;
  private static long RUNTIME = 100000;

  public Program(String program, String action, int count)
  {
    this.program = program;
    this.action = action;
    this.count = count;
  }
  @Override public void run()
  {
    for (int i = 0; i < count; i++)
    {

      try
      {
        Thread.sleep(RUNTIME/1000);
      }
      catch (InterruptedException e)
      {
        throw new RuntimeException(e);
      }
      System.out.println(program + ": " + action);
    }
  }

}
