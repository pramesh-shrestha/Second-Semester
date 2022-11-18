package CarrotPeelerV2;

import java.util.LinkedList;
import java.util.Queue;

public class CarrotQueue
{
  private LinkedList<Carrot> carrots;
  private int maxSize;

  public CarrotQueue(int maxSize)
  {
    this.maxSize = maxSize;
    carrots = new LinkedList<>();
  }

  public synchronized void peel(Carrot carrot)
  {
    while(carrots.size() > maxSize)
    {
      try
      {
        System.out.println("peeler waiting");
        wait();
      }
      catch (InterruptedException e)
      {
        throw new RuntimeException(e);
      }
    }
    carrots.add(carrot);
    System.out.println("Carrot is peeled.");
    if(carrots.size() <= 4)
      notifyAll();
  }

  public synchronized void eat()
  {
    while(carrots.size() <= 0)
    {
      try
      {
        System.out.println("carrot eater waiting");
        wait();
      }
      catch (InterruptedException e)
      {
        throw new RuntimeException(e);
      }
    }
    carrots.removeFirst();
    if(carrots.size() <= 4)
      notifyAll();
    System.out.println("Carrot is eaten");
  }
}
