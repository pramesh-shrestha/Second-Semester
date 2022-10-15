package ex4_Temperature.view;

import ex4_Temperature.viewModel.TemperatureViewModel;
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
  private TemperatureViewModel temperatureViewModel;


  public void init(TemperatureViewModel temperatureViewModel)
  {
    this.temperatureViewModel = temperatureViewModel;
    filterField.textProperty().bindBidirectional(temperatureViewModel.filterFieldProperty());
    filterLabel.textProperty().bind(temperatureViewModel.filterLabelProperty());
    outputLabel.textProperty().bind(temperatureViewModel.outputLabelProperty());
  }
  public void updateButtonPressed( )
  {
    temperatureViewModel.update();
  }

  public void onFilter()
  {
    try{
      temperatureViewModel.filter();
    } catch (NullPointerException e)
    {
      System.out.println("Enter t1 or t2 to in the FilterField");
    }

  }
}

