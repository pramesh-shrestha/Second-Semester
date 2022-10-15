package ex2_uppercase_converter.core;

import ex2_uppercase_converter.view.UppercaseViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler
{
  private Scene uppercaseScene;
  private Stage stage;

  private ViewModelFactory viewModelFactory;

    public ViewHandler (ViewModelFactory viewModelFactory)
    {
      this.viewModelFactory = viewModelFactory;
    }
  public void start()
  {
    stage = new Stage();
    openToUppercase();
  }
  public void openToUppercase()
  {
    if(uppercaseScene == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../view/UppercaseView.fxml"));
        Parent root = loader.load();
        UppercaseViewController controller = loader.getController();
        controller.init(viewModelFactory.getUppercaseViewModel());
        stage.setTitle("Upper case");
        uppercaseScene = new Scene(root);
      }
      catch (IOException e)
      {
        throw new RuntimeException(e);
      }
    }
    stage.setScene(uppercaseScene);
    stage.show();
  }
}
