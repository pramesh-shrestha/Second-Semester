package ex4_Toilet;

public class CleaningPerson implements Runnable {
  private ToiletBuilding toilet;

  public CleaningPerson(ToiletBuilding toilet) {
    this.toilet = toilet;
  }

  @Override
  public void run() {
    while (true) {
      toilet.startCleaning();
      toilet.clean();
      System.out.println("Toilets are being cleaned.");
      toilet.endCleaning();
      try {
        Thread.sleep(1000);
      }
      catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }
}
