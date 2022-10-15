package ex2_uppercase_converter.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class UppercaseViewController
{
  @FXML
  private TextField requestField;
  @FXML
  private TextField replyField;
  @FXML
  private Label errorLabel;
  private UppercaseViewModel uppercaseViewModel;

  public void init(UppercaseViewModel uppercaseViewModel)
  {
    this.uppercaseViewModel = uppercaseViewModel;
    requestField.textProperty().bindBidirectional(uppercaseViewModel.requestProperty());
    replyField.textProperty().bind(uppercaseViewModel.replyProperty());
    errorLabel.textProperty().bind(uppercaseViewModel.errorLabelProperty());
  }

  public void onSubmitButton(ActionEvent actionEvent)
  {
    uppercaseViewModel.convert();
  }
}
