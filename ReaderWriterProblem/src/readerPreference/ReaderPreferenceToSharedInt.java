package readerPreference;

public class ReaderPreferenceToSharedInt implements ReadWrite
{
  private boolean activeWriter;
  private int activeReader;
  private int waitingReader;
  private int sharedInt;

  @Override
  public synchronized void acquireRead()
  {
    //it is request for the read access to shared resource
    //in the start it is waiting
    waitingReader++;
    while (activeWriter){
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
    while(activeWriter || activeReader > 0 || waitingReader > 0){
      try {
        wait();
      }
      catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
    activeWriter = true;
  }

  @Override
  public synchronized void releaseWrite()
  {
    activeWriter = false;
    notifyAll();
  }

  public int readInt()
  {
    return sharedInt;
  }

  public void incrementInt()
  {
    sharedInt++;
  }
}
