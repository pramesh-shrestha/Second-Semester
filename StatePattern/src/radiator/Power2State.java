package radiator;

public class Power2State implements RadiatorState
{
  private static int POWER = 2;


  @Override public void onTurnUp(Radiator radiator)
  {
    radiator.setPowerState(new Power3State(radiator));
  }

  @Override public void onTurnDown(Radiator radiator)
  {
    System.out.println("Turn down button pressed...Now transitioning back to Power1State from Power2State");
    radiator.setPowerState(new Power1State());
  }

  @Override public int getPower()
  {
    return POWER;
  }

}
