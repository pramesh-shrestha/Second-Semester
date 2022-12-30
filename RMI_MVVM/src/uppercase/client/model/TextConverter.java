package uppercase.client.model;

import uppercase.shared.transferobjects.LogEntry;
import uppercase.shared.util.Subject;

import java.util.List;

public interface TextConverter extends Subject {

    String toUppercase(String text);
    List<LogEntry> getLogs();

}


