package Session2_Thread.Ex_2_5_computer;

public class Mailbox implements Runnable {
  private int count;
  private static int RUNTIME = 100000;

  public Mailbox(int count) {
    this.count = count;
  }

  @Override
  public void run() {
    for (int i = 0; i < count; i++) {
      System.out.println("New mail in your mailbox...");
      try {
        Thread.sleep(RUNTIME/30);
      }
      catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }
}
