package lesson6_1.view;

import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import lesson6_1.viewmodel.ViewModelFactory;

public class ViewHandler
{
  private Stage primaryStage;
  private Scene currentScene;
  private ViewModelFactory viewModelFactory;
  private ViewFactory viewFactory;
  public ViewHandler(ViewModelFactory viewModelFactory)
  {
    this.viewFactory = new ViewFactory(this, viewModelFactory);
    currentScene=new Scene(new Region());
  }
  public void start(Stage primaryStage)
  {
    this.primaryStage=primaryStage;
    openView("convert");
  }
  public void openView(String id)
  {
    Region root = viewFactory.loadView(id);
    currentScene.setRoot(root);
    if (root.getUserData() == null) {
      primaryStage.setTitle("");
    } else {
      primaryStage.setTitle(root.getUserData().toString());
    }
    primaryStage.setScene(currentScene);
    primaryStage.sizeToScene();
    primaryStage.show();
  }

  public void closeView()
  {}
}
