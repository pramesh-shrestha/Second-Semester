package ex2_TemperatureWithObserver.core;


import ex2_TemperatureWithObserver.view.TemperatureViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler
{
  private Scene currentScene;
  private Stage currentStage;
  private ViewModelFactory viewModelFactory;

  public ViewHandler(ViewModelFactory viewModelFactory)
  {
    this.viewModelFactory = viewModelFactory;
  }

  public void start()
  {
    currentStage = new Stage();
    openTemperatureView();
  }

  private void openTemperatureView()
  {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("../view/TemperatureView.fxml"));
    try
    {
      Parent root = loader.load();
      TemperatureViewController controller = loader.getController();
      controller.init(viewModelFactory.getTemperatureViewModel());
      currentScene = new Scene(root);

    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }
    currentStage.setScene(currentScene);
    currentStage.setTitle("Temperature Presenter");
    currentStage.show();
  }
}
