package Session1_Thread.Ex_1_5;

public class Numbers implements Runnable {
  private int start;
  private int end;
  public Numbers(int start, int end) {
    this.start = start;
    this.end = end;
  }

  @Override
  public void run() {
    for(int i = start; i <= end; i++) {
      System.out.println(i);
    }
  }
}