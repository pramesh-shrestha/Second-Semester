package Session1_Thread.counter;

public class Counter {
  private long value = 0;

  public synchronized void inc() {
    value++;
  }

  public synchronized long value() {
    return value;
  }
}
