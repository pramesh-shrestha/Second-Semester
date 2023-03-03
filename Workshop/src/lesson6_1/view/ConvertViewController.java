package lesson6_1.view;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import lesson6_1.viewmodel.ConvertViewModel;


public class ConvertViewController
{
  @FXML
  private TextField requestField;
  @FXML
  private TextField replyField;
  @FXML
  private Label errorLabel;
  private ViewHandler viewHandler;
  private ConvertViewModel viewModel;
  private Region root;

  public void init(ViewHandler viewHandler, ConvertViewModel viewModel, Region root)
  {
    this.viewHandler=viewHandler;
    this.viewModel=viewModel;
    this.root=root;

    this.viewModel.bindRequest(requestField.textProperty());
    this.viewModel.bindReply(replyField.textProperty());
    this.viewModel.bindError(errorLabel.textProperty());

  }
  public void reset()
  {}

  public Region getRoot()
  {
    return root;
  }
  @FXML
  public void onSubmit()
  {viewModel.convert();}
  @FXML
  public void onEnter()
  {
    viewModel.convert();
  }

  @FXML
  public void onShowLog()
  {
    viewHandler.openView("log");
  }

}
