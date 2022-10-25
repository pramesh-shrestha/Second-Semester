package Exercises_part2.ex4_Counter_v4;

public class Test
{
  public static void main(String[] args)
  {
    Counter counter = new Counter(1,20);
    CounterIncrement counterIncrement1 = new CounterIncrement(counter);
    CounterDecrement counterDecrement1 = new CounterDecrement(counter);

    Thread thread1 = new Thread(counterIncrement1);
    Thread thread2 = new Thread(counterDecrement1);

    thread1.start();
    thread2.start();

  }
}
