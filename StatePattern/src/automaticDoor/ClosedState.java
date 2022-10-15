package automaticDoor;

public class ClosedState implements DoorState
{
  @Override public void close(Door door)
  {
    System.out.println("Door is already closed.");
  }

  @Override public void open(Door door)
  {
    //Changing the door state to opened
    door.setDoorState(new OpeningState(door));
  }

}
