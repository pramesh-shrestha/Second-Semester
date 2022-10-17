package ex1_uppercase.View;

import ex1_uppercase.ViewModel.ViewModelFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class ViewHandler
{
  private Stage primaryStage;
  private Scene currentScene;
  private UpperCaseViewController upperCaseViewController;
  private ViewModelFactory viewModelFactory;

  public ViewHandler(ViewModelFactory viewModelFactory)
  {
    this.viewModelFactory = viewModelFactory;
  }

  public void start(Stage stage)
  {
    primaryStage = stage;
    openView();
  }

  public void openView()
  {

    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("UppercaseView.fxml"));
    try
    {
      Parent root = loader.load();
      upperCaseViewController = loader.getController();
      upperCaseViewController.init(this,viewModelFactory.getViewModel());
      Scene scene = new Scene(root);
      primaryStage.setScene(scene);
      primaryStage.show();

    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }
  }
}
