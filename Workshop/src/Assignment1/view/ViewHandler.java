package Assignment1.view;

import Assignment1.viewModel.ViewModelFactory;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;


public class ViewHandler {
  private Stage stage;
  private Scene currentScene;
  private ViewFactory viewFactory;


  public ViewHandler(ViewModelFactory viewModelFactory) {
    viewFactory = new ViewFactory(this, viewModelFactory);
    currentScene = new Scene(new Region());
  }

  public void start(){
    stage = new Stage();
    openView(ViewFactory.MAINVIEW);
  }

  public void openView(String id){
    Region root = viewFactory.load(id);
    currentScene.setRoot(root);
    if (root.getUserData() == null) {
      stage.setTitle("");
    } else {
      stage.setTitle(root.getUserData().toString());
    }
    stage.setScene(currentScene);
    stage.sizeToScene();
    stage.show();
  }
}
