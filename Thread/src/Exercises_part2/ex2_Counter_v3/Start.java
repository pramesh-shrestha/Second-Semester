package Exercises_part2.ex2_Counter_v3;

public class Start
{
  public static void main(String[] args)
  {
    Counter counter = new Counter();
    Thread thread1 = new Thread(new CountIncrementer(counter));
    Thread thread2 = new Thread(new CountIncrementer(counter));

    thread1.start();
    thread2.start();

  }
}
