package Session1_Thread.Ex_1_6;

public class CountIncrementer implements Runnable{
  private Counter counter;

  public CountIncrementer(Counter counter) {
    this.counter = counter;
  }
  private int update(){
    for (int i = 0; i < 1000000; i++) {
      counter.increment();
    }
    return counter.getCount();
  }

  @Override
  public void run() {
    System.out.println(update());
  }
}
