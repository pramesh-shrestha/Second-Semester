package Exercises_part2.ex4_Counter_v4;

public class CounterDecrementer implements Runnable
{
  private int updates;
  private Counter counter;

  public CounterDecrementer(Counter counter,int updates)
  {
    this.updates = updates;
    this.counter = counter;
  }

  @Override public void run()
  {
    for (int i = 0; i < updates; i++)
    {
      counter.decrement();

    }
    System.out.println(counter.getValue());

  }
}
