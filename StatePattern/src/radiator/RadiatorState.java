package radiator;

public interface RadiatorState
{
  public void onTurnUp(Radiator radiator);
  public void onTurnDown(Radiator radiator);
  public int getPower();
}
