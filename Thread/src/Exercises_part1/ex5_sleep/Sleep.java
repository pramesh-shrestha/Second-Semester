//Create a Runnable class which prints out a number each second. Can you do it using both the Runnable
//interface and the lambda expression approach?
//Modify the code so your Runnable class takes an argument to print out a number each second for X seconds.

package Exercises_part1.ex5_sleep;

public class Sleep implements Runnable
{
  private int secs;

  public Sleep(int secs)
  {
    this.secs = secs;
  }

  @Override public void run()
  {
    for (int i = 1; i < 10; i++)
    {
      try
      {
        Thread.sleep(secs);
      }
      catch (InterruptedException e)
      {
        System.out.println("Just wait...you idiot");
      }
      System.out.println(i);
    }
  }
}
