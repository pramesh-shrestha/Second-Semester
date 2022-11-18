package ex1_ReaderPreference;

public class ReaderPreferenceToSharedInt implements ReadWrite
{
  private int activeWriter = 0;
  private int activeReader = 0;
  private int waitingReader = 0;
  private int sharedInt = 0;

  @Override
  public synchronized void acquireRead()
  {
    //it is request for the read access to shared resource
    //in the start it is waiting
    waitingReader++;
    while (activeWriter > 0){
      try {
        wait();
      }
      catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
    waitingReader--;
    activeReader++;
  }

  @Override
  public synchronized void releaseRead()
  {
    activeReader--;
    if(activeReader == 0)
      notifyAll();
  }

  @Override
  public synchronized void acquireWrite()
  {
    while(activeWriter > 0 || activeReader > 0 || waitingReader > 0){
      try {
        wait();
      }
      catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
    activeWriter++;
  }

  @Override
  public synchronized void releaseWrite()
  {
    activeWriter--;
    notifyAll();
  }

  public int doRead()
  {
    return sharedInt;
  }

  public void doWrite()
  {
    sharedInt++;
  }
}
