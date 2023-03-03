package Assignment1.view;

import Assignment1.viewModel.AddVinylViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

public class AddVinylController {
  @FXML
  private Label errorLabel;
  @FXML
  private TextField nameField;
  @FXML
  private TextField statusField;
  @FXML
  private TextField titleField;
  @FXML
  private TextField yearField;
  private AddVinylViewModel addVinylViewModel;
  private ViewHandler viewHandler;
  private Region root;

  public void init(AddVinylViewModel addVinylViewModel, ViewHandler viewHandler,Region root){
    this.root = root;
    this.addVinylViewModel = addVinylViewModel;
    this.viewHandler = viewHandler;
    addVinylViewModel.bindingError(errorLabel.textProperty());
    addVinylViewModel.bindName(nameField.textProperty());
    addVinylViewModel.bindStatus(statusField.textProperty());
    addVinylViewModel.bindTitle(titleField.textProperty());
    addVinylViewModel.bindYear(yearField.textProperty());
  }
  public void onAdd() {
    addVinylViewModel.addVinyl();
  }
  public void onCancel(ActionEvent actionEvent) {
    addVinylViewModel.reset();
  }
  public void onBack() {
    viewHandler.openView(ViewFactory.MAINVIEW);
  }

  public Region getRoot() {
    return root;
  }
}
