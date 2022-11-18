package writerPreference;

import java.util.Random;

public class RunExample {
  public static void main(String[] args) {
    Random random = new Random();
    WriterPreferenceToSharedInt rp = new WriterPreferenceToSharedInt();
    for (int i = 0; i < 3; i++) {
      new Thread(() -> {
        while (true) {
          rp.acquireWrite();
          rp.incrementInt();
          rp.releaseWrite();
          try {
            Thread.sleep( 200 + random.nextInt(50));
          }
          catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
        }
      }).start();
    }

    for (int i = 0; i < 50; i++) {
      int finalI = i;
      new Thread(()->{
        while (true) {
          rp.acquireRead();
          int result = rp.readInt();
          System.out.println("reader " + finalI + ": " + result);
          rp.releaseRead();
          try {
            Thread.sleep(random.nextInt(5));
          }
          catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
        }
      }).start();
    }
  }
}
