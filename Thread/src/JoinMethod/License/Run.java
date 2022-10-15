package JoinMethod.License;

public class Run
{
  public static void main(String[] args)
  {
    Thread medical = new Thread(new Medical());
    medical.start();

    Thread driving = new Thread(new DrivingTest(medical));
    driving.start();

    Thread officer = new Thread(new Officer(driving));
    officer.start();

//    Thread medical = new Thread(new Medical());
//    medical.start();
//    try
//    {
//      medical.join();
//    }
//    catch (InterruptedException e)
//    {
//      throw new RuntimeException(e);
//    }
//    Thread driving = new Thread(new DrivingTest());
//    driving.start();
//    try
//    {
//      driving.join();
//    }
//    catch (InterruptedException e)
//    {
//      throw new RuntimeException(e);
//    }
//    Thread officer = new Thread(new Officer());
//    officer.start();
//    try
//    {
//      officer.join();
//    }
//    catch (InterruptedException e)
//    {
//      throw new RuntimeException(e);
//    }

  }
}
