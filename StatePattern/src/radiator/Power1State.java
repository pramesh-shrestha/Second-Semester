package radiator;

public class Power1State implements RadiatorState
{
  private static int POWER = 1;
  @Override public void onTurnUp(Radiator radiator)
  {
    System.out.println("Turn up button pressed...Now transitioning to Power2State from Power1State");
    radiator.setPowerState(new Power2State());
  }

  @Override public void onTurnDown(Radiator radiator)
  {
    System.out.println("Turn down button pressed...Now transitioning back to OffState from Power1State");
    radiator.setPowerState(new OffState());
  }

  @Override public int getPower()
  {
    return POWER;
  }
}
