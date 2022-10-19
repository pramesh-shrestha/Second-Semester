package uppercaseWithLogs.core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import uppercaseWithLogs.view.ViewController;

import java.io.IOException;

public class ViewHandler
{
  private Stage stage;
  private Scene upperCaseScene;
  private ViewModelFactory viewModelFactory;

  public ViewHandler(ViewModelFactory viewModelFactory)
  {
    this.viewModelFactory = viewModelFactory;
  }

  public void start()
  {
    stage = new Stage();
    openToUpperCase();
  }

  private Parent loadFXML(String path) throws IOException
  {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource(path));
    Parent root = loader.load();

    ViewController controller = loader.getController();
    controller.init(this, viewModelFactory);
    return root;
  }

  public void openToUpperCase()
  {
    if (upperCaseScene == null) {
      try {
        Parent root = loadFXML("../view/uppercase/UppercaseView.fxml");

        stage.setTitle("Upper case");
        upperCaseScene = new Scene(root);
      }
      catch (IOException e) {
        e.printStackTrace();
      }
    }
    stage.setScene(upperCaseScene);
    stage.show();
  }

  public void openLog()
  {
    try {
      Parent root = loadFXML("../view/log/log.fxml");

      Scene logScene = new Scene(root);
      stage.setTitle("Log");
      stage.setScene(logScene);
      stage.show();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


}
