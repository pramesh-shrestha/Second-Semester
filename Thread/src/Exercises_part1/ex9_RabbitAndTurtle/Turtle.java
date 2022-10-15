package Exercises_part1.ex9_RabbitAndTurtle;

public class Turtle implements Runnable
{
  private int turtleCount;

  public Turtle(int turtleCount)
  {
    this.turtleCount = turtleCount;
  }

  public int getTurtleCount()
  {
    return turtleCount;
  }

  @Override public void run()
  {
    for (int i = 1; i <= 100; i++)
    {
      try
      {
        System.out.println("Turtle is running.");
        Thread.sleep(1000);
          turtleCount++;

      }
      catch (InterruptedException e)
      {
        throw new RuntimeException(e);
      }
    }
  }
}
