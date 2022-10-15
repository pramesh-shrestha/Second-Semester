package ex1_TimestampWtihObserver.model;

public interface DataModel extends PropertyChangeSubject{

    String getLastUpdateTimeStamp();
    void increaseNumberOfUpdates();
    int getNumberOfUpdates();
    void counter();
    int getCount();
}
