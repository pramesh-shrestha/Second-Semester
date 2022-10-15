package ex1_TimestampWtihObserver.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataModelManager implements DataModel {

    private String lastUpdate;
    private int numberOfUpdates;
    private PropertyChangeSupport propertyChangeSupport;
    private int count = 0;

    public DataModelManager() {
        propertyChangeSupport = new PropertyChangeSupport(this);
    }

    @Override
    public String getLastUpdateTimeStamp() {
        return lastUpdate;
    }

    @Override
    public void increaseNumberOfUpdates() {
        numberOfUpdates++;
    }

    @Override
    public int getNumberOfUpdates() {
        return numberOfUpdates;
    }

    @Override public void counter()
    {
        int value = getCount();
        if(value % 10 == 0)
        {
            propertyChangeSupport.firePropertyChange("Green", null, value);
        }
        else
            propertyChangeSupport.firePropertyChange("Red", null, value);

    }

    public void recalculateData() {
        count++; //counts number of times this method is called
        String last = lastUpdate;
        calcTimeStamp();
        propertyChangeSupport.firePropertyChange("Updated", last, lastUpdate);
        counter();

    }

    private void calcTimeStamp() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("HH:mm:ss");
        Date now = new Date();
        String strDate = sdfDate.format(now);
        System.out.println(strDate);
        lastUpdate = strDate;
    }

    //returns the count
    @Override
    public int getCount()
    {
        return count;
    }

    @Override
    public void addPropertyChangeListener(String name, PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(name, listener);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(String name, PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(name, listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
}
