package ex4_Thermometer.view;

import ex4_Thermometer.core.ViewHandler;
import ex4_Thermometer.viewModel.TemperatureViewModel;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TemperatureViewController
{
  @FXML
  private TextField filterField;
  @FXML
  private Label filterLabel;
  @FXML
  private Label outputLabel;
  private TemperatureViewModel viewModel;
  private ViewHandler viewHandler;

  public void init(ViewHandler viewHandler, TemperatureViewModel viewModel)
  {
    this.viewHandler = viewHandler;
    this.viewModel = viewModel;
    filterField.textProperty().bindBidirectional(viewModel.filterFieldProperty());
    filterLabel.textProperty().bind(viewModel.filterLabelProperty());
    outputLabel.textProperty().bind(viewModel.outputLabelProperty());

    reset();
  }

  public void reset()
  {
    updateButtonPressed();
  }
  @FXML
  private void updateButtonPressed()
  {
    Platform.runLater(()->{
    viewModel.getValue();
  });
  }
  @FXML
  private void onFilter()
  {
    Platform.runLater(()->{
    viewModel.updateThermometerId();
    });
  }
}
