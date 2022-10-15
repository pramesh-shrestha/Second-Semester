package automaticDoor;

public class ClosingState implements DoorState
{

  public ClosingState(Door door)
  {
    System.out.println("Door is closing back.");
    try
    {
      Thread.sleep(5000);
      System.out.println("Door is now closed.");
      door.setDoorState(new ClosedState());
    }
    catch (InterruptedException e)
    {
      open(door);
    }
  }
  @Override public void close(Door door)
  {
    System.out.println("Door closing in process.");

  }

  @Override public void open(Door door)
  {
    System.out.println("Door is opening back.");
    door.setDoorState(new OpeningState(door));
  }
}
