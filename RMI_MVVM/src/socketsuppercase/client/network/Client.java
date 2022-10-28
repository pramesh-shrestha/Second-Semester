package socketsuppercase.client.network;

import socketsuppercase.shared.transferobjects.LogEntry;
import socketsuppercase.shared.util.Subject;

import java.util.List;

public interface Client extends Subject
{
  String toUpperCase(String str);
  List<LogEntry> getLog();
  void startClient();
}
