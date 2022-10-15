package Exercises_part2.ex4_Counter_v4;

public class CounterIncrementer implements Runnable
{
  private int updates;
  private Counter counter;

  public CounterIncrementer(Counter counter,int updates)
  {
    this.updates = updates;
    this.counter = counter;
  }
  @Override public void run()
  {
    for (int i = 0; i < updates; i++)
    {
      synchronized (counter)
      {
        counter.increment();
      }
    }
    System.out.println(counter.getValue());
  }
}
