package timestamp.server.model;

import timestamp.client.model.PropertyChangeSubject;

import java.util.Date;

public interface DataModel extends PropertyChangeSubject
{

    String getLastUpdateTimeStamp();
    int getNumberOfUpdates();
    void setTimeStamp(Date timeStamp);
}
