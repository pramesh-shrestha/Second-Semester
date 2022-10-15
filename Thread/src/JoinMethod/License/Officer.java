package JoinMethod.License;

public class Officer implements Runnable
{
  private Thread drivingTestThread;

  public Officer(Thread drivingTestThread)
  {
    this.drivingTestThread = drivingTestThread;
  }

  @Override public void run()
  {
    try
    {
      drivingTestThread.join();
      System.out.println("Test analysis begins");
      Thread.sleep(2000);
      System.out.println("Driving test passed");
      Thread.sleep(2000);
      System.out.println("License issued");
    }
    catch (InterruptedException e)
    {
      throw new RuntimeException(e);
    }
  }
}
