package Session1_Thread;

public class StartingThread implements Runnable {
  @Override
  public void run() {
    System.out.println("Hello from a Runnable thread");
  }

  public static void main(String[] args) {
    new Thread(new StartingThread()).start();
  }
}
