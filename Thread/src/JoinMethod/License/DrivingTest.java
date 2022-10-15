package JoinMethod.License;

public class DrivingTest implements Runnable
{
  private Thread medicalThread;

  public DrivingTest(Thread medicalThread)
  {
    this.medicalThread = medicalThread;
  }


  @Override public void run()
  {
    try
    {
      medicalThread.join();
      System.out.println("Driving test starts.");
      Thread.sleep(2000);
      System.out.println("Driving test ends");
      Thread.sleep(2000);
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
  }
}
