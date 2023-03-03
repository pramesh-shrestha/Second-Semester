package Session1_Thread.Ex_1_7;

public class Number{
  private int x;
  public Number(int x) {
    this.x = x;
  }


  public void run() {
    for (int i = 0; i < x; i++) {
      System.out.println(i);
      try {
        Thread.sleep(1000);
      }
      catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }
}
