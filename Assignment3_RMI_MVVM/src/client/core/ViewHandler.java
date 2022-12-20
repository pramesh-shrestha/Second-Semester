package client.core;

import client.clientView.ViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler
{
  private Scene signUpScene;
  private Scene loginScene;
  private Scene chatScene;
  private Scene privateScene;
  private Stage stage;
  private ViewModelFactory vmf;

  public ViewHandler(ViewModelFactory vmf)
  {
    this.vmf = vmf;
  }

  public void start()
  {
    stage = new Stage();
    openSignUpWindow();
  }

  public ViewModelFactory getVmf()
  {
    return vmf;
  }

  public void openSignUpWindow()
  {
    try
    {
      Parent root = loadFXML("../clientView/signUp.fxml");
      signUpScene = new Scene(root);
    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }
    stage.setTitle("Sign up");
    stage.setScene(signUpScene);
    stage.show();
  }

  public void openLoginWindow()
  {
    try
    {
      Parent root = loadFXML("../clientView/userLogin.fxml");
      loginScene = new Scene(root);
    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }
    stage.setTitle("Login");
    stage.setScene(loginScene);
    stage.show();
  }

  public void openChatWindow()
  {
    try
    {
      Parent root = loadFXML("../clientView/chatWindow.fxml");
      chatScene = new Scene(root);
    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }
    stage.setTitle("Click Chat");
    stage.setScene(chatScene);
    stage.show();
  }

  public void openPrivateChatWindow(){
    try
    {
      Parent root = loadFXML("../clientView/chatWindow.fxml");
      privateScene = new Scene(root);
    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }
    Stage privateStage = new Stage();
    privateStage.setScene(privateScene);
    privateStage.show();
  }
  private Parent loadFXML(String path) throws IOException
  {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource(path));
    Parent root = loader.load();

    ViewController ctrl = loader.getController();
    ctrl.init(this, vmf);
    return root;
  }
}
