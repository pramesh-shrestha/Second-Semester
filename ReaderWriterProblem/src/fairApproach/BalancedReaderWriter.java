package fairApproach;

import ex3_LimitReaders.ReadWrite;

public class BalancedReaderWriter implements ReadWrite
{
  private int activeWriter = 0;
  private int activeReader = 0;
  private int waitingWriters = 0;
  private int waitingReaders = 0;
  private int sharedInt = 0;


  @Override
  public synchronized void acquireRead()
  {
    waitingReaders++;
    while (activeWriter > 0 || waitingWriters > waitingReaders){
      try {
        if(activeWriter > 0)
          System.out.println("Could not acquire read because of the active writer");
        else if (waitingWriters > waitingReaders)
          System.out.println("Could not acquire read because of the more waiting writers.");
        wait();
      }
      catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
      waitingReaders--;
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
    while(activeWriter > 0 || activeReader > 0 || waitingReaders > waitingWriters){
      try {
        if(activeWriter > 0)
          System.out.println("Could not acquire write because of the active writer.");
        else if (activeReader > 0)
          System.out.println("Could not acquire write because of the active readers.");
        else if(waitingReaders > waitingWriters)
          System.out.println("Could not acquire write because of the more waiting readers.");
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
