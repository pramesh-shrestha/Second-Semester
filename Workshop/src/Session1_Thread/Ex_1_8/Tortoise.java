package Session1_Thread.Ex_1_8;

public class Tortoise implements Runnable{
  private int count = 0;
  public void increment(){
    count++;
  }

  public int getCount() {
    return count;
  }

  @Override
  public void run() {
    for (int i = 0; i < 1000; i++) {
      increment();
      try {
        Thread.sleep(10);
      }
      catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
    System.out.println("Tortoise reached the finish line.");
  }
}
