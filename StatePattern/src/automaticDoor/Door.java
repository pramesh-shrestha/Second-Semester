package automaticDoor;

public class Door
{
  private DoorState currentState;

  public Door(DoorState doorState)
  {
    currentState = doorState;
  }

  public void close()
  {
    currentState.close(this);
  }
  public void open()
  {
    currentState.open(this);
  }

  public void setDoorState(DoorState doorState)
  {
    currentState = doorState;
  }

  public DoorState getCurrentState()
  {
    return currentState;
  }
}
