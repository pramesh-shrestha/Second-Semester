package Exercises_part2.ex2_Counter_v3;

public class CountIncrementer implements Runnable
{
  private Counter counter;

  public CountIncrementer(Counter counter)
  {
    this.counter = counter;
  }

  @Override public void run()
  {
    for (int i = 0; i < 10000; i++)
    {
      counter.updateCount();
    }
    System.out.println(counter.getCount());


  }


}
