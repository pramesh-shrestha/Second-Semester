package writerPreference;

public class WriterPreferenceToSharedInt implements ReadWrite
{
  private boolean activeWriter;
  private int waitingWriters;
  private int activeReader;
  private int sharedInt;

  @Override
  public synchronized void acquireRead()
  {
    while (activeWriter || waitingWriters > 0){
      try {
        wait();
      }
      catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
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
    //we do not care about the waiting readers
    waitingWriters++;
    while(activeWriter || activeReader > 0){
      try {
        wait();
      }
      catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
    waitingWriters--;
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
