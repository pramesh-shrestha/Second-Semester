package timestamp.client.network;

import timestamp.client.model.PropertyChangeSubject;

import java.util.Date;

public interface Client extends PropertyChangeSubject
{
  String getLastUpdateTimeStamp();
  int getNumberOfUpdates();
  void setTimeStamp(Date timeStamp);
  void startClient();
}
