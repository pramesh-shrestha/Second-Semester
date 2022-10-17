package ex3_ex2Extension.server;

public class Counter
{
  private int count;
  private int max;
  private int min;

  public Counter(int max, int min)
  {
    count = 0;
    this.max = max;
    this.min = min;
  }

  public synchronized void increment()
  {
    Thread.currentThread().setName("Increment thread");
    while(count >= max)
    {
      try
      {
        System.out.println(Thread.currentThread().getName() + " is waiting");
        wait();
      }
      catch (InterruptedException e)
      {
        throw new RuntimeException(e);
      }
    }
    count++;
    System.out.println(Thread.currentThread().getName() + " increments " + count);
    if(count >= max)
      notifyAll();
  }

  public synchronized void decrement()
  {
    Thread.currentThread().setName("Decrement thread");
    while(count <= min)
    {
      try
      {
        System.out.println(Thread.currentThread().getName() + " is waiting");
        wait();
      }
      catch (InterruptedException e)
      {
        throw new RuntimeException(e);
      }
    }
    count--;
    System.out.println(Thread.currentThread().getName() + " decrements " + count);
    if(count <= min)
      notifyAll();
  }

  public synchronized int getCount()
  {
    return count;
  }
}
