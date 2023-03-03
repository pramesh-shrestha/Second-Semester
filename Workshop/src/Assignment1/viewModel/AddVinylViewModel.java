package Assignment1.viewModel;

import Assignment1.model.IModel;
import Assignment1.model.Vinyl;
import Assignment1.model.VinylState;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;

public class AddVinylViewModel {
  private StringProperty title, name, year, status, error;
  private IModel model;

  public AddVinylViewModel(IModel model) {
    this.model = model;
    title = new SimpleStringProperty();
    name = new SimpleStringProperty();
    year = new SimpleStringProperty();
    status = new SimpleStringProperty();
    error = new SimpleStringProperty();

  }



  public void bindTitle(StringProperty property){
    property.bindBidirectional(title);
  }
  public void bindName(StringProperty property){
    property.bindBidirectional(name);
  }
  public void bindYear(StringProperty property){
    property.bindBidirectional(year);
  }
  public void bindStatus(StringProperty property){
    property.bindBidirectional(status);
  }
  public void bindingError(StringProperty property){
    property.bind(error);
  }

  public void reset() {
    title.set("");
    name.set("");
    year.set("");
    status.set("");
    error.set("");
  }

  public void addVinyl() {
    model.addVinyl(new Vinyl(title.get(), name.get(), Integer.parseInt(year.get()),status.get()));
  }
}
