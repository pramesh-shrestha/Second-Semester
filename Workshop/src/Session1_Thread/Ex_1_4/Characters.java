package Session1_Thread.Ex_1_4;

public class Characters implements Runnable {
  private int num;
  public Characters(int num) {
    this.num = num;
  }

  @Override
  public void run() {
    for(int i = 0; i < num; i++) {
      for (char c = 'A'; c <= 'Z'; c++) {
        System.out.println(c);
      }
    }
  }
}