package ex3_DoctorsWaitingRoom;

import ex3_DoctorsWaitingRoom.Observer.Patient;
import ex3_DoctorsWaitingRoom.Subject.WaitingRoom;

public class Test
{
  public static void main(String[] args)
  {
    WaitingRoom waitingRoom = new WaitingRoom();
    Thread waitingRoomThread = new Thread(waitingRoom);
    waitingRoomThread.setDaemon(true);
    waitingRoomThread.start();

    for (int i = 0; i < 5; i++)
    {
      Patient patient = new Patient(i,waitingRoom);
      waitingRoom.addPropertyChangeListener(patient);
      try
      {
        Thread.sleep(700);
      }
      catch (InterruptedException e)
      {
        throw new RuntimeException(e);
      }

    }
  }
}
