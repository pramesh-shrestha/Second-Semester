package ex3_DoctorsWaitingRoom.Observer;

import ex3_DoctorsWaitingRoom.Subject.WaitingRoom;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Patient implements PropertyChangeListener
{
  private int ticketNumber;
  private WaitingRoom waitingRoom;

  public Patient(int ticketNumber, WaitingRoom waitingRoom)
  {
    this.ticketNumber = ticketNumber;
    this.waitingRoom = waitingRoom;
    System.out.println("Patient " + ticketNumber + " enters waiting room");

  }
  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    int oldValue = (int)evt.getOldValue();

    System.out.println("Patient " + ticketNumber + " looks up");
    if(oldValue == ticketNumber)
    {
      System.out.println("Patient " + ticketNumber + " goes to the doctor's room.");
      waitingRoom.removePropertyChangeListener(this);
    }
    else
    {
      System.out.println("Patient " + ticketNumber + " goes back to looking at phone.");
    }

  }

}
