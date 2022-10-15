package ex1_TimestampWtihObserver.model;

import java.beans.PropertyChangeListener;

public interface PropertyChangeSubject {

    public void addPropertyChangeListener(String name, PropertyChangeListener listener);
    public void addPropertyChangeListener(PropertyChangeListener listener);
    public void removePropertyChangeListener(String name, PropertyChangeListener listener);
    public void removePropertyChangeListener(PropertyChangeListener listener);

}

