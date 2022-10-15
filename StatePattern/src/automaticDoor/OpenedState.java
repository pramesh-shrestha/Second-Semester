package automaticDoor;

public class OpenedState implements DoorState
{


  @Override public void close(Door door)
  {
    door.setDoorState(new ClosingState(door));
  }

  @Override public void open(Door door)
  {
    System.out.println("Door is already opened.");
  }


}
