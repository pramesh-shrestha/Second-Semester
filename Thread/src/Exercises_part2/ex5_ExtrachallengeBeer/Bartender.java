package Exercises_part2.ex5_ExtrachallengeBeer;

public class Bartender implements Runnable
{
  private Bar bar;
  private Beer beer;
  private Thread bartender = Thread.currentThread();

  public Bartender(Bar bar, Beer beer)
  {
    this.bar = bar;
    this.beer = beer;
  }

  public Thread getBartenderThread()
  {
    return bartender;
  }

  @Override public synchronized void run()
  {
    while(bar.isBarOpen())
    {
      try
      {
        Thread.sleep(1000);
        bar.placeBeer(beer);
        System.out.println("Bartender added a beer to the bar.");
      }
      catch (InterruptedException e)
      {
        throw new RuntimeException(e);
      }

    }

  }
}
