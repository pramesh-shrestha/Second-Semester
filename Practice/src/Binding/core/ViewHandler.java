package Binding.core;


import Binding.view.SimpleTextController;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler
{
  private Scene scene;
  private Stage stage;
  private ViewModelFactory viewModelFactory;

  public ViewHandler(ViewModelFactory viewModelFactory)
  {
    this.viewModelFactory = viewModelFactory;

  }

  public void start()
  {
    stage = new Stage();
    callToUppercase();
  }

  public void callToUppercase()
  {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("../view/simpleText.fxml"));
    try
    {
      Parent root = loader.load();
      SimpleTextController controller = loader.getController();
      controller.init(this, viewModelFactory.getConverterViewModel());
      scene = new Scene(root);
      stage.setScene(scene);
      stage.show();
    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }
  }
}
