package Counter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter
{
  private int countA;
  private int countB;
  private Lock lockA = new ReentrantLock();
  private Lock lockB = new ReentrantLock();

  public Counter()
  {
    countA = 0;
    countB = 0;
  }

  public void updateA()
  {
    synchronized (lockA)
    {
      countA++;

    }
  }
  public void updateB()
  {
    synchronized (lockB)
    {
      countB++;
    }
  }

  public int getCountA()
  {
    synchronized (lockA){

      return countA;
    }
  }

  public synchronized int getCountB()
  {
    synchronized (lockB){

      return countB;
    }
  }
}
