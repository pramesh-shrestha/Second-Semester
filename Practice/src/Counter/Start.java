package Counter;

public class Start
{
  public static void main(String[] args)
  {
    Counter counter = new Counter();
    Thread thread1 = new Thread(new CounterIncrementer(counter));
    Thread thread2 = new Thread(new CounterIncrementer(counter));
    thread1.start();
    thread2.start();
  }
}
