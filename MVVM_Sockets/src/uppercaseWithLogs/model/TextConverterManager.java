package uppercaseWithLogs.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class TextConverterManager implements TextConverter
{
  private List<LogEntry> logs;
  private PropertyChangeSupport support;

  public TextConverterManager()
  {
    logs = new ArrayList<>();
    support = new PropertyChangeSupport(this);
  }

  @Override
  public List<LogEntry> getLogs()
  {
    return logs;
  }

  @Override
  public String toUpperCase(String str)
  {
    String result = str.toUpperCase();
    LogEntry logEntry = new LogEntry(str,result);
    logs.add(logEntry);
//    support.firePropertyChange("LogAdded",null, logEntry);  //Observer is not implemented in this system
    return result;
  }

  @Override
  public void addListener(String evtName,PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(evtName,listener);
  }

  @Override
  public void removeListener(String evtName, PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(evtName,listener);
  }
}
