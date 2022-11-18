package ex4_Toilet;

public class ToiletBuilding implements PublicToilet{
  private int activeToiletUser = 0;
  private int activeToiletCleaner = 0;
  private int waitingToiletUser = 0;
  private int toilet = 5;
  private int size;

  public ToiletBuilding(int size) {
    this.size = size;
  }

  @Override
  public synchronized void stepIntoCabin() {
    waitingToiletUser++;
    while(activeToiletUser >= 5)
    {
      try {
        wait();
      }
      catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
    waitingToiletUser--;
    activeToiletUser++;
    toilet--;
  }

  @Override
  public synchronized void leaveCabin() {
    activeToiletUser--;
    toilet++;
    if(activeToiletUser == 0)
      notifyAll();
  }

  @Override
  public synchronized void startCleaning() {
    while(activeToiletUser > 0 || waitingToiletUser > 0)
    {
      try {
        wait();
      }
      catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
    activeToiletCleaner++;
  }

  @Override
  public synchronized void endCleaning() {
    activeToiletCleaner--;
    if(activeToiletCleaner == 0)
      notifyAll();
  }

  public int useToilet() {

    return toilet;
  }

  public void clean() {
    toilet++;
  }

  public int getSize() {
    return size;
  }

  public int getActiveToiletUser() {
    return activeToiletUser;
  }
}
