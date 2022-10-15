package Exercises_part2.ex5_ExtrachallengeBeer;

import java.util.ArrayList;

public class Bar implements Runnable
{
  private ArrayList<Beer> beers;
  private int beersOnTheBar;
  private boolean barIsOpen;


  public Bar(boolean barIsOpen)
  {
    this.barIsOpen = barIsOpen;
    beersOnTheBar = 20;
    beers = new ArrayList<>();
  }

  public int getBeersOnTheBar()
  {
    return beersOnTheBar;
  }

  public boolean isBarOpen()
  {
    return barIsOpen;
  }

  public synchronized void placeBeer(Beer b)
  {
      if(beers.size() >= beersOnTheBar && barIsOpen)
      {
        System.out.println("Bar is full.");
        try
        {
          wait();

        }
        catch (InterruptedException e)
        {
          throw new RuntimeException(e);
        }
      }
      else
      {
        beers.add(b);
        notifyAll();
      }
  }

  public synchronized void takeBeer()
  {
      if(beers.size() <= 0 && barIsOpen)
      {
        try
        {
          wait();
          System.out.println("Bar is empty.");
        }
        catch (InterruptedException e)
        {
          throw new RuntimeException(e);
        }
      }
      else
      {
        beers.remove(0);
        notifyAll();
      }
  }

  @Override public void run()
  {
      try
      {
        Thread.sleep(10000);
        barIsOpen = false;
          Thread.sleep(1000);
          System.out.println("Bar is closed now.");
          Thread.sleep(1000);
          System.out.println("Bartenders stopped placing beers.");
          Thread.sleep(1000);
          System.out.println("Customers stopped buying beers and start to leave.");
          Thread.sleep(1000);
          System.out.println("All customers left.");
      }
      catch (InterruptedException e)
      {
        throw new RuntimeException(e);
      }
  }
}

