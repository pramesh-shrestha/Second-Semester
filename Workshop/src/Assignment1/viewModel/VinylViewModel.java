package Assignment1.viewModel;

import Assignment1.model.IModel;
import Assignment1.model.Vinyl;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeEvent;


public class VinylViewModel {
  private IModel model;
  private ListProperty<String> listViews;
  private ObservableList<String> vinyls;
  private ObservableList<Vinyl> vinylLists;


  public VinylViewModel(IModel model) {
    this.model = model;
    listViews = new SimpleListProperty<>();
    vinyls = FXCollections.observableArrayList();
    vinylLists = FXCollections.observableArrayList();
    model.addListener("addedVinyl", this::newVinylAdded);
    model.addListener("reservedVinyl", this::vinylReserved);
  }

  private void vinylReserved(PropertyChangeEvent event) {
    Vinyl vinyl = (Vinyl) event.getNewValue();
    for (int i = 0; i < vinylLists.size(); i++) {
      if(vinylLists.get(i).equals(vinyl))
        vinyl.setState("Reserved");
    }
  }

  private void newVinylAdded(PropertyChangeEvent event) {
    Vinyl vinyl = (Vinyl) event.getNewValue();
    vinyls.add(vinyl.getTitle());
    listViews.set(vinyls);
    vinylLists.add(vinyl);
  }
  public void bindingListView(ObjectProperty<ObservableList<String>> property){
    property.bind(listViews);
  }

  public ObservableList<Vinyl> getVinylLists() {
    return vinylLists;
  }

  public void reserve(Vinyl vinyl) {
    model.reserve(vinyl);
  }
}
