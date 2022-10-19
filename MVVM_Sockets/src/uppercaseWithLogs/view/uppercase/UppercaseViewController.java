package uppercaseWithLogs.view.uppercase;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import uppercaseWithLogs.core.ViewHandler;
import uppercaseWithLogs.core.ViewModelFactory;
import uppercaseWithLogs.view.ViewController;
import uppercaseWithLogs.viewModel.UpperCaseViewModel;

public class UppercaseViewController implements ViewController
{
  @FXML
  private Label errorLabel;
  @FXML
  private TextField replyField;
  @FXML
  private TextField requestField;
  private UpperCaseViewModel upperCaseViewModel;
  private ViewHandler viewHandler;

  @Override
  public void init(ViewHandler vh, ViewModelFactory vmf)
  {
    viewHandler = vh;
    this.upperCaseViewModel = vmf.getUpperCaseVM();
    errorLabel.textProperty().bind(upperCaseViewModel.errorLabelProperty());
    replyField.textProperty().bind(upperCaseViewModel.replyProperty());
    requestField.textProperty().bindBidirectional(upperCaseViewModel.requestProperty());
  }

  @FXML
  private void onSubmitButton()
  {
    upperCaseViewModel.convert();
  }

  @FXML
  private void onShow()
  {
    viewHandler.openLog();
  }


}
