package uppercaseWithLogs.model;

import uppercaseWithLogs.util.PropertyChangeSubject;

import java.util.List;

public interface TextConverter extends PropertyChangeSubject
{
   List<LogEntry> getLogs();
   String toUpperCase(String str);
}
