package view.temperature;

import javafx.fxml.FXML;
import core.ViewHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import viewModel.TemperatureViewModel;

public class TemperatureViewController
{
  @FXML
  private TextField outdoorTempField;
  @FXML
  private TextField thermometer1Field;
  @FXML
  private TextField thermometer2Field;
  @FXML
  private Label warningLabel;
  private TemperatureViewModel temperatureViewModel;
  private ViewHandler viewHandler;
  //init method
  public void init(TemperatureViewModel temperatureViewModel, ViewHandler viewHandler)
  {
    this.temperatureViewModel = temperatureViewModel;
    this.viewHandler = viewHandler;
    //binding
    outdoorTempField.textProperty().bind(temperatureViewModel.outdoorFieldProperty());
    thermometer1Field.textProperty().bind(temperatureViewModel.thermometer1Property());
    thermometer2Field.textProperty().bind(temperatureViewModel.thermometer2Property());
    warningLabel.textProperty().bind(temperatureViewModel.warningProperty());
  }

  public void onGetHeatPowerButton()
  {
    viewHandler.openHeaterPowerView();
  }

}
