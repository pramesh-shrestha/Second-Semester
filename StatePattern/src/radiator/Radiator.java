package radiator;

public class Radiator
{
  private RadiatorState currentState;

  //creating constructor to initiate the private field 'currentState'
  public Radiator(RadiatorState initialState)
  {
    currentState = initialState;
  }
  public void turnUp()
  {
    currentState.onTurnUp(this);
  }

 public void turnDown()
  {
    currentState.onTurnDown(this);
  }

  public int getPower()
  {
    return currentState.getPower();
  }
  public void setPowerState(RadiatorState state)
  {
    currentState = state;
  }

}
