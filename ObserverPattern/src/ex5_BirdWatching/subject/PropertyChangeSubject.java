package ex5_BirdWatching.subject;

import java.beans.PropertyChangeListener;

public interface PropertyChangeSubject
{
  //creating methods needed to add and remove the listeners
  //The reason we have PropertyChangeListener reference as an argument is
  //because we must be able to add or remove listeners
  public void addPropertyChangeListener(PropertyChangeListener listener);
  public void addPropertyChangeListener(String eventName,PropertyChangeListener listener);
  public void removePropertyChangeListener(PropertyChangeListener listener);
  public void removePropertyChangeListener(String eventName,PropertyChangeListener listener);
}
