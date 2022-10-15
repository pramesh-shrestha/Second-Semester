package Exercises_part2.ex4_Counter_v4;

public class Test
{
  public static void main(String[] args)
  {
    Counter counter = new Counter(1,20);
    CounterIncrementer counterIncrementer1 = new CounterIncrementer(counter,200);
    CounterIncrementer counterIncrementer2 = new CounterIncrementer(counter,200);
    CounterDecrementer counterDecrementer1 = new CounterDecrementer(counter,200);
    CounterDecrementer counterDecrementer2 = new CounterDecrementer(counter,200);

    Thread thread1 = new Thread(counterIncrementer1);
    Thread thread2 = new Thread(counterIncrementer2);
    Thread thread3 = new Thread(counterDecrementer1);
    Thread thread4 = new Thread(counterDecrementer2);

    thread1.start();
    thread2.start();
    thread3.start();
    thread4.start();
  }
}
