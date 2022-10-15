package ex3_UppercaseTwoViews.view.uppercase;

import ex3_UppercaseTwoViews.core.ModelFactory;
import ex3_UppercaseTwoViews.core.ViewHandler;
import ex3_UppercaseTwoViews.core.ViewModelFactory;
import ex3_UppercaseTwoViews.view.log.LogViewModel;
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
  private ViewHandler viewHandler;

  public void init(UppercaseViewModel uppercaseViewModel,ViewHandler viewHandler)
  {
    this.viewHandler = viewHandler;
    this.uppercaseViewModel = uppercaseViewModel;
    requestField.textProperty().bindBidirectional(uppercaseViewModel.requestProperty());
    replyField.textProperty().bind(uppercaseViewModel.replyProperty());
    errorLabel.textProperty().bind(uppercaseViewModel.errorLabelProperty());
  }
  @FXML
  private void onSubmitButton(ActionEvent actionEvent)
  {
    uppercaseViewModel.convert();
    uppercaseViewModel.openView(requestField.getText());

  }
  @FXML
  private void onShow(ActionEvent actionEvent)
  {
    uppercaseViewModel.clear();
    viewHandler.openLogView();
  }
}