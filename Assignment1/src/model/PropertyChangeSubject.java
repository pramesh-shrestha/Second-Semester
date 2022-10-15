package model;

import java.beans.PropertyChangeListener;
import java.net.http.WebSocket;

public interface PropertyChangeSubject
{
  void addPropertyChangeListener(String name, PropertyChangeListener listener);
  void addPropertyChangeListener(PropertyChangeListener listener);
  void removePropertyChangeListener(String name, PropertyChangeListener listener);
  void removePropertyChangeListener(PropertyChangeListener listener);
}
