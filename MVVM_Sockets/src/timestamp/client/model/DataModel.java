package timestamp.client.model;

import java.util.Date;

public interface DataModel extends PropertyChangeSubject {

    String getLastUpdateTimeStamp();
    int getNumberOfUpdates();
    void setTimeStamp(Date timeStamp);
}
