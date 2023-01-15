package core;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.heater.HeatPowerViewController;
import view.temperature.TemperatureViewController;

import java.io.IOException;

public class ViewHandler
{
  private Scene temperatureScene;
  private Scene heaterPowerScene;
  private Stage stage;
  private ViewModelFactory viewModelFactory;
  public ViewHandler(ViewModelFactory viewModelFactory)
  {
    this.viewModelFactory = viewModelFactory;
  }
  public void start()
  {
    stage = new Stage();
    openTemperatureView();
  }

  public void openTemperatureView()
  {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource(
        "../view/temperature/TemperatureView.fxml"));
    try
    {
      Parent root = loader.load();
      TemperatureViewController controller = loader.getController();
      controller.init(viewModelFactory.getTemperatureViewModel(),this);
      stage.setTitle("Temperature Presenter");
      temperatureScene = new Scene(root);
      stage.setScene(temperatureScene);
      stage.show();
    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }
  }

  public void openHeaterPowerView()
  {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("../view/heater/HeatPowerView.fxml"));
    try
    {
      Parent root = loader.load();
      HeatPowerViewController controller = loader.getController();
      controller.init(viewModelFactory.getHeaterPowerViewModel(),this);
      stage.setTitle("Heater Power");
      heaterPowerScene = new Scene(root);
      stage.setScene(heaterPowerScene);
      stage.show();
    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }
  }
}
