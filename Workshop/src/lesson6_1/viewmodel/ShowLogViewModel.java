package lesson6_1.viewmodel;

import javafx.beans.Observable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import lesson6_1.model.Model;
import lesson6_1.view.ShowLogViewController;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;

public class ShowLogViewModel
{
  private Model model;
  @FXML
  private ListView<String> logList;
  private ObservableList list;


  public ShowLogViewModel(Model model)
  {
    this.model=model;
    logList = new ListView<>();
    list = FXCollections.observableArrayList(model.getLogs());
    model.addListener((evt) -> addedNewWord());

  }
  private void addedNewWord() {
   logList.itemsProperty().setValue(list);
  }
 public void bindLogs(ObjectProperty<ObservableList<String>> property)
 {
   property.bind(logList.itemsProperty());
 }
}
