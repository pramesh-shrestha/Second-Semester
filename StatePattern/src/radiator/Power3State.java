package radiator;

public class Power3State implements RadiatorState
{
  private static int POWER = 3;
  private Thread thread;

  public Power3State(Radiator radiator)
  {
    System.out.println("Turn up button pressed...Now transitioning to Power3State from Power2State");
     Runnable myThread = () -> {
      try
      {
        Thread.sleep(9000);
        System.out.println("Automatic transition to Power2State from Power3State after 10 seconds");
        radiator.setPowerState(new Power2State());
      }
      catch (InterruptedException e)
      {
      }
    };
     thread = new Thread(myThread);
     thread.start();
  }
  @Override public void onTurnUp(Radiator radiator)
  {
    System.out.println("Radiator is already on highest power state");
  }

  @Override public void onTurnDown(Radiator radiator)
  {
    System.out.println("Thread interrupted");
    thread.interrupt();
    radiator.setPowerState(new Power2State());
  }

  @Override public int getPower()
  {
    return POWER;
  }


}
