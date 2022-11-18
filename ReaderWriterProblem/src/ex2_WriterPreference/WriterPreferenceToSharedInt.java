package ex2_WriterPreference;

public class WriterPreferenceToSharedInt implements ReadWrite
{
  private int activeWriter = 0;
  private int activeReader = 0;
  private int waitingWriters = 0;
  private int sharedInt = 0;

  @Override
  public synchronized void acquireRead()
  {
    //it is request for the read access to shared resource
    //in the start it is waiting

    while (activeWriter > 0 || waitingWriters > 0){
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
    waitingWriters++;
    while(activeWriter > 0 || activeReader > 0){
      try {
        wait();
      }
      catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
    waitingWriters--;
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
