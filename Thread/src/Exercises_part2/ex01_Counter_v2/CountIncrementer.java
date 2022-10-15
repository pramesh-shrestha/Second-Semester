package Exercises_part2.ex01_Counter_v2;

public class CountIncrementer implements Runnable
{
  private Counter counter;

  public CountIncrementer(Counter counter)
  {
    this.counter = counter;
  }

  @Override public void run()
  {
    for (int i = 0; i < 1000000; i++)
    {
        counter.updateCountA();
        counter.updateCountB();
    }
    System.out.println(counter.getCountA());
    System.out.println(counter.getCountB());


  }


}
