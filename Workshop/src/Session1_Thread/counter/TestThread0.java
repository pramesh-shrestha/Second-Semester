package Session1_Thread.counter;

public class TestThread0 {
  public static void main (String[] args) throws InterruptedException {
    Counter counter = new Counter();
    Thread th0 = new Thread0("Thread0", counter);
    Thread th1 = new Thread0("Thread1", counter);
    th0.start();
    th1.start();
  }
}
