package ex1_ReaderPreference;

public class Test {
  public static void main(String[] args) {
    ReaderPreferenceToSharedInt sr = new ReaderPreferenceToSharedInt();

    for (int i = 0; i < 5; i++) {
      new Thread(() -> {
        while (true) {
          sr.acquireRead();
          System.out.println("Readers read: " +sr.doRead());
          sr.releaseRead();

          try {
            Thread.sleep(200);
          }
          catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
        }
    }).start();
    }

    for (int i = 0; i < 2; i++) {
      new Thread(()->{
          while(true){
          sr.acquireWrite();
          sr.doWrite();
            System.out.println("\t\t\t\t\t\t\t\t\twriter increments the sharedInt " + sr.doRead());
          sr.releaseWrite();
            try {
              Thread.sleep(100);
            }
            catch (InterruptedException e) {
              throw new RuntimeException(e);
            }
          }
      }).start();
    }
  }
}
