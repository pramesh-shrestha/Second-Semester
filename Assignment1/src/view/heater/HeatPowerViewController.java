package view.heater;

import core.ViewHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import viewModel.HeaterPowerViewModel;

public class HeatPowerViewController
{
  @FXML
  private Label powerPositionLabel;

  @FXML
  private TextField powerPositionField;

  private HeaterPowerViewModel heaterPowerViewModel;
  private ViewHandler viewHandler;

  public void init(HeaterPowerViewModel heaterPowerViewModel, ViewHandler viewHandler)
  {
   this.heaterPowerViewModel = heaterPowerViewModel;
   this.viewHandler = viewHandler;

   powerPositionLabel.textProperty().bind(heaterPowerViewModel.powerPositionProperty());
   powerPositionField.textProperty().bind(heaterPowerViewModel.powerUpDownProperty());
  }

  public void onBackButton()
  {
    viewHandler.openTemperatureView();
  }

  //On clicking up button
  public void onUpButton()
  {
    heaterPowerViewModel.upButton();
  }

  //On clicking down button
  public void onDownButton()
  {
      heaterPowerViewModel.downButton();
  }
}
