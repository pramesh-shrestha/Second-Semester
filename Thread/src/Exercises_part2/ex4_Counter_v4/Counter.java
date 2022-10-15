package Exercises_part2.ex4_Counter_v4;

public class Counter
{
  private long value;
  private long max;
  private long min;

  public Counter(long min, long max)
  {
    value = 0;
    this.min = min;
    this.max = max;
  }

  public synchronized  void increment()
  {
    if(value >= max)
    {
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        throw new RuntimeException(e);
      }
    }
    value++;
    System.out.println(value + ":" + Thread.currentThread().getName());
    notifyAll();
  }

  public synchronized void decrement()
  {
    if(value <= min)
    {
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        throw new RuntimeException(e);
      }
    }
    value--;
    System.out.println(value + ":" + Thread.currentThread().getName());
    notifyAll();

  }

  public synchronized long getValue()
  {
    return value;
  }
}
