package JoinMethod.License;

public class Medical implements Runnable
{
  private Thread medicalThread = Thread.currentThread();

  @Override public void run()
  {
    try
    {
      System.out.println("Medical Starts");
      Thread.sleep(2000);
      System.out.println("Medical Ends");
      Thread.sleep(2000);
    }
    catch (InterruptedException e)
    {
      throw new RuntimeException(e);
    }
  }
}
