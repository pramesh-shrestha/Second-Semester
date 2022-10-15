package automaticDoor;

public class OpeningState implements DoorState
{
  public OpeningState(Door door)
  {
    Runnable openingState = () -> {
    System.out.println("Door is opening");
    try
    {
      Thread.sleep(5000);
      System.out.println("Door is now opened.");
      door.setDoorState(new OpenedState());
    }
    catch (InterruptedException e)
    {
      close(door);
    }
    };

    Thread thread = new Thread(openingState);
    thread.start();
    thread.interrupt();
  }

  @Override public void close(Door door)
  {
    door.setDoorState(new ClosingState(door));
  }

  @Override public void open(Door door)
  {
    System.out.println("Door opening in process...");
  }

}
