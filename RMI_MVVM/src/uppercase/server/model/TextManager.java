package uppercase.server.model;


import uppercase.shared.transferobjects.LogEntry;
import uppercase.shared.util.Subject;

import java.util.List;

public interface TextManager extends Subject {

    String toUppercase(String str);
    List<LogEntry> getLog();
}
