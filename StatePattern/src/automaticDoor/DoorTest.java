package automaticDoor;

public class DoorTest
{
  public static void main(String[] args)
  {

    //instantiating a initial door state
    ClosedState closedState = new ClosedState();
    //Creating door object
    Door door = new Door(closedState);
    door.open();
    System.out.println(door.getCurrentState());
  }
}
