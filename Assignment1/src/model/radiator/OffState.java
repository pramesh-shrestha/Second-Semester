package model.radiator;

public class OffState implements RadiatorState
{

  private static int POWER = 0;


  
  @Override public void onTurnUp(Radiator radiator)
  {
    System.out.println("Turn up button pressed...Now transitioning to Power1State from OffState");
    radiator.setPowerState(new Power1State());
  }

  @Override public void onTurnDown(Radiator radiator)
  {
    //In the OffState turning down does nothing
  }

  @Override public int getPower()
  {
    return POWER;
  }

}
