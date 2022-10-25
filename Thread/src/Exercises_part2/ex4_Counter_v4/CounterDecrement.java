package Exercises_part2.ex4_Counter_v4;

public class CounterDecrement implements Runnable
{

  private Counter counter;

  public CounterDecrement(Counter counter )
  {
    this.counter = counter;
  }

  @Override public void run()
  {
    Thread.currentThread().setName("Decrementing Thread");

    while (true)
    {
      counter.decrement();
    }

  }
}
