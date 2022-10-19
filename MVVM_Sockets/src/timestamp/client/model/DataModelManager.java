package timestamp.client.model;


import timestamp.client.network.Client;
import timestamp.server.model.DataModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataModelManager implements DataModel, PropertyChangeSubject {

    private Client client;
    private String lastUpdate;
    private int numberOfUpdates;
    private PropertyChangeSupport propertyChangeSupport;

    public DataModelManager(Client client)
    {
        this.client = client;
        client.startClient();
        propertyChangeSupport.addPropertyChangeListener("updated", this::updated);
        propertyChangeSupport = new PropertyChangeSupport(this);
    }

    private void updated(PropertyChangeEvent event)
    {
        propertyChangeSupport.firePropertyChange(event);
    }

    @Override
    public String getLastUpdateTimeStamp() {
        return client.getLastUpdateTimeStamp();
    }

    @Override
    public int getNumberOfUpdates() {
        return client.getNumberOfUpdates();
    }

    @Override
    public void setTimeStamp(Date timeStamp) {
        client.setTimeStamp(timeStamp);
//        SimpleDateFormat sdfDate = new SimpleDateFormat("HH:mm:ss");
//        String strDate = sdfDate.format(timeStamp);
//        System.out.println(strDate);
//        String last = lastUpdate;
//        lastUpdate = strDate;
//        numberOfUpdates++;
//        propertyChangeSupport.firePropertyChange("Updated", last, lastUpdate);
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
