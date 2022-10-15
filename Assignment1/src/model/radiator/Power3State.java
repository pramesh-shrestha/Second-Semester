package model.radiator;

import model.TemperatureModel;

public class Power3State implements RadiatorState
{
  private static int POWER = 3;
  private Thread thread;
  public Power3State(Radiator radiator)
  {
    Runnable radiatorLambda = () -> {
      try
      {
        Thread.sleep(30000);
        System.out.println("Turn down button pressed...Now transitioning back to Power2State from Power3State after 30 seconds");
        radiator.setPowerState(new Power2State());
      }
      catch (InterruptedException e)
      {
      }
    };
    thread = new Thread(radiatorLambda);
    thread.setDaemon(true);
    thread.start();

  }
  @Override public void onTurnUp(Radiator radiator)
  {
    //In this state turning up does nothing
  }

  @Override public void onTurnDown(Radiator radiator)
  {
    thread.interrupt();
    radiator.setPowerState(new Power2State());
  }

  @Override public int getPower()
  {
    return POWER;
  }



}
