package Exercises_part2.ex4_Counter_v4;

public class CounterIncrement implements Runnable
{

  private Counter counter;


  public CounterIncrement(Counter counter)
  {
    this.counter = counter;

  }
  @Override public void run()
  {
    Thread.currentThread().setName("Incrementing thread");

  while(true)
  {
    counter.increment();
  }



  }
}
