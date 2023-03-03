package uppercaseWS.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import uppercaseWS.viewmodel.ConvertViewModel;

public class ControlViewController {
  @FXML
  private Label errorLabel;
  @FXML
  private TextField replyfield;
  @FXML
  private TextField requestField;
  private ViewHandler viewHandler;
  private ConvertViewModel convertViewModel;
  private Region root;

public void init(ViewHandler viewHandler, ConvertViewModel convertViewModel, Region root){
  this.viewHandler = viewHandler;
  this.convertViewModel = convertViewModel;
  this.root = root;

  convertViewModel.bindReply(replyfield.textProperty());
  convertViewModel.bindRequest(requestField.textProperty());
  convertViewModel.bindError(errorLabel.textProperty());
}

  public Region getRoot() {
    return root;
  }

  public void onSubmit() {
    convertViewModel.convert(requestField.getText());
  }
}
