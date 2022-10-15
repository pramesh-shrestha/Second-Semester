package JoinMethod.Test2;

public class ChildThread implements Runnable
{
  private Thread mainThread;
  public ChildThread(Thread mainThread)
  {
    this.mainThread = mainThread;
  }

  public Thread getMainThread()
  {
    return mainThread;
  }

  @Override public void run()
    {
      try
      {
        mainThread.join();
        for (int i = 1; i < 5; i++)
        {
          Thread.sleep(1000);
          System.out.println("Child thread " + i);
        }
      }
      catch (InterruptedException e)
      {
        throw new RuntimeException(e);
      }

    }
}
