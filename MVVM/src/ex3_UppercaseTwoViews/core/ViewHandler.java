package ex3_UppercaseTwoViews.core;

import ex3_UppercaseTwoViews.view.log.LogViewController;
import ex3_UppercaseTwoViews.view.uppercase.UppercaseViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler
{
  private Scene uppercaseScene;
  private Scene convertLogScene;
  private Stage stage;
//  private Stage stage1;
  private ViewModelFactory viewModelFactory;

    public ViewHandler (ViewModelFactory viewModelFactory)
    {
      this.viewModelFactory = viewModelFactory;
    }
  public void start()
  {
    stage = new Stage();
//    stage1 = new Stage();
    openToUppercase();
  }

  public void openToUppercase()
  {
    if(uppercaseScene == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../view/uppercase/UppercaseView.fxml"));
        Parent root = loader.load();
        UppercaseViewController controller = loader.getController();
        controller.init(viewModelFactory.getUppercaseViewModel(),this);
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

  public void openLogView()
  {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("../view/log/LogView.fxml"));
    try
    {
      Parent root = loader.load();
      LogViewController logViewController = loader.getController();
      logViewController.init(viewModelFactory.getLogViewModel(),this);
      stage.setTitle("Converter Log");
      convertLogScene = new Scene(root);
      stage.setScene(convertLogScene);
      stage.show();
    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }
  }
}
