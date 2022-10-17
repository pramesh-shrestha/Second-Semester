package ex1_uppercase.View;

import ex1_uppercase.ViewModel.ConvertViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

public class UpperCaseViewController
{
  @FXML
  private TextField requestField;
  @FXML
  private TextField replyField;
  @FXML
  private Label errorLabel;

  private ConvertViewModel convertViewModel;
  private Region root;
  private ViewHandler viewHandler;

  //init method perform a binding to ViewModel
  public void init(ViewHandler viewHandler, ConvertViewModel convertViewModel)
  {
    this.viewHandler = viewHandler;
    this.convertViewModel = convertViewModel;
    requestField.textProperty().bindBidirectional(convertViewModel.requestProperty());
    replyField.textProperty().bind(convertViewModel.replyProperty());
    errorLabel.textProperty().bind(convertViewModel.errorProperty());

  }

  public Region getRoot()
  {
    return root;
  }

  public void reset()
  {

  }

  public void onSubmitButton(ActionEvent actionEvent)
  {
    convertViewModel.convert();
  }
}
