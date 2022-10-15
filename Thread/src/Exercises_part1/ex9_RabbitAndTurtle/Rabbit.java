package Exercises_part1.ex9_RabbitAndTurtle;

import java.util.Random;

public class Rabbit implements Runnable
{
  private Turtle turtle;
  private int rabbitCount;

  public Rabbit(int rabbitCount,Turtle turtle)
  {
    this.rabbitCount = rabbitCount;
    this.turtle = turtle;
  }

  public int getRabbitCount()
  {
    return rabbitCount;
  }

  @Override public void run()
  {
    for (int i = 1; i <= 100 ; i++)
    {
      try
      {
        Thread.sleep(500);
        rabbitCount++;
        System.out.println("Rabbit is running.");
        if(rabbitCount == 100 && rabbitCount > turtle.getTurtleCount())
          System.out.println("Rabbit is winner.");
        else if(turtle.getTurtleCount() == 100 && turtle.getTurtleCount() > rabbitCount)
          System.out.println("Turtle is winner.");

      }
      catch (InterruptedException e)
      {
        throw new RuntimeException(e);
      }
      if(rabbitCount - turtle.getTurtleCount() > 2)
      {
        int randomNumber = new Random().nextInt(4000) + 1000; //will give random number between 1000 and 4999
        try
        {
          System.out.println("Rabbit is sleeping.");
          Thread.sleep(randomNumber);
        }
        catch (InterruptedException e)
        {
          System.out.println("Interrupted");
        }
      }
    }
  }
}
