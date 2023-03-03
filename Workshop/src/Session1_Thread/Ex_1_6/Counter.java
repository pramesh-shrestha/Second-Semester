package Session1_Thread.Ex_1_6;

public class Counter {
  private int count;

  public Counter() {
    count = 0;
  }
  public synchronized void increment(){
    count++;
  }

  public synchronized int getCount() {
    return count;
  }
}
