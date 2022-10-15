package ex2_TemperatureWithObserver.view;

import ex2_TemperatureWithObserver.viewModel.TemperatureViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class TemperatureViewController
{
  @FXML
  private Label outputLabel1;

  @FXML
  private Label outputLabel2;

  private TemperatureViewModel temperatureViewModel;


  public void init(TemperatureViewModel temperatureViewModel)
  {
    this.temperatureViewModel = temperatureViewModel;
    outputLabel1.textProperty().bind(temperatureViewModel.outputLabel1Property());
    outputLabel2.textProperty().bind(temperatureViewModel.outputLabel2Property());
  }

}

