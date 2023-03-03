package Session4_Observer.birdWatcher;

import Session4_Observer.soccerMatch.PropertyChangeSubject;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;

public class Bird implements PropertyChangeSubject {

  private PropertyChangeSupport support;
  private String wingsFlash;
  private String whistle;

  public Bird() {
    support = new PropertyChangeSupport(this);
  }

  public void BirdBehavior(){

    Random random = new Random();
    while (true) {
      int number = random.nextInt(2);

      if(number == 0)
      {
        wingsFlash = "wings flashes";
        flashWings();
      }
      else
      {
        whistle ="whistles";
        birdWhistle();
      }
      //making the Thread sleep for a second
      try
      {
        Thread.sleep(1000);
      }
      catch (InterruptedException e)
      {
        throw new RuntimeException(e);
      }
    }
  }
  private void flashWings()
  {
    String wingsNoFlash = "";
    System.out.println("Peacock flashes wings.");
    try
    {
      Thread.sleep(1000);
    }
    catch (InterruptedException e)
    {
      throw new RuntimeException(e);
    }
    support.firePropertyChange("flash",wingsNoFlash,wingsFlash);
  }

  private void birdWhistle()
  {

    String noWhistle = "";
    System.out.println("Peacock whistles.");
    try
    {
      Thread.sleep(1000);
    }
    catch (InterruptedException e)
    {
      throw new RuntimeException(e);
    }
    support.firePropertyChange("whistle",noWhistle,whistle);
  }


  @Override
  public void addPropertyChangeListener(PropertyChangeListener listener) {
    support.addPropertyChangeListener(listener);
  }

  @Override
  public void addPropertyChangeListener(String eventName, PropertyChangeListener listener) {
    support.addPropertyChangeListener(eventName,listener);
  }

  @Override
  public void removePropertyChangeListener(PropertyChangeListener listener) {
      support.removePropertyChangeListener(listener);
  }

  @Override
  public void removePropertyChangeListener(String eventName, PropertyChangeListener listener) {
    support.removePropertyChangeListener(eventName,listener);
  }
}
