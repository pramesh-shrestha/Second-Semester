package Session1_Thread.Ex_1_4;

public class Numbers implements Runnable {
  private int num;
  public Numbers(int num) {
    this.num = num;
  }

  @Override
  public void run() {
    for(int i = 0; i < num; i++) {
      System.out.println(i);
    }
  }
}