package Session2_Thread.Ex_2_5_computer;

public class Program implements Runnable {
  private String program;
  private String action;
  private int count;
  private static int RUNTIME = 100000;

  public Program(String program, String action, int count) {
    this.program = program;
    this.action = action;
    this.count = count;
  }

  @Override
  public void run() {
    for (int i = 0; i < count; i++) {
      System.out.println(action);
      try {
        Thread.sleep(RUNTIME/30);
      }
      catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }
}
