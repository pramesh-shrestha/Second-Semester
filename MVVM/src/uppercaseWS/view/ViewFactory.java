package uppercaseWS.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Region;
import uppercaseWS.viewmodel.ViewModelFactory;

import java.io.IOException;

public class ViewFactory {
  private ViewHandler viewHandler;
  private ViewModelFactory viewModelFactory;
  private ControlViewController controlViewController;

  public ViewFactory(ViewHandler viewHandler, ViewModelFactory viewModelFactory) {
    this.viewHandler = viewHandler;
    this.viewModelFactory = viewModelFactory;
  }

  public Region loadView(){
    return loadConvertView();
  }

  public Region loadConvertView(){
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("ControlView.fxml"));
    try {
      Region root = loader.load();
      controlViewController = loader.getController();
      controlViewController.init(viewHandler,viewModelFactory.getConvertViewModel(),root);
    }
    catch (IOException e) {
      throw new RuntimeException(e);
    }
    return controlViewController.getRoot();
  }
}
