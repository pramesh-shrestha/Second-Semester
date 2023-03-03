package Assignment1.model;



import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class Model implements IModel{
  private List<Vinyl> lists;
  private PropertyChangeSupport support;


  public Model(){
    lists = new ArrayList<>();
    support = new PropertyChangeSupport(this);
  }
  @Override
  public void addVinyl(Vinyl vinyl) {
    lists.add(vinyl);
    support.firePropertyChange("addedVinyl",null, vinyl);
  }

  @Override
  public void reserve(Vinyl vinyl) {
    vinyl.setCurrentState(new ReservedState());
    support.firePropertyChange("reservedVinyl", null, vinyl);
  }

  @Override
  public void borrow(Vinyl vinyl) {

  }

  @Override
  public void addListener(PropertyChangeListener listener) {
    support.addPropertyChangeListener(listener);
  }
  @Override
  public void addListener(String eventName, PropertyChangeListener listener) {
    support.addPropertyChangeListener(eventName,listener);
  }
  @Override
  public void removeListener(PropertyChangeListener listener) {
    support.removePropertyChangeListener(listener);
  }
  @Override
  public void removeListener(String eventName, PropertyChangeListener listener) {
    support.removePropertyChangeListener(eventName,listener);
  }
}
