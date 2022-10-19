package uppercaseWithLogs.util;

import java.beans.PropertyChangeListener;

public interface PropertyChangeSubject
{
  void addListener(String evtName, PropertyChangeListener listener);
  void removeListener(String evtName, PropertyChangeListener listener);
}
