package Assignment1.view;

import Assignment1.viewModel.ViewModelFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Region;

import java.io.IOException;

public class ViewFactory {
  public final static String MAINVIEW = "mainView";
  public final static String ADDVIEW = "addView";
  private ViewHandler viewHandler;
  private ViewModelFactory viewModelFactory;
  private AddVinylController addVinylController;
  private VinylController vinylController;

  public ViewFactory(ViewHandler viewHandler, ViewModelFactory viewModelFactory) {
    this.viewHandler = viewHandler;
    this.viewModelFactory = viewModelFactory;
  }

  public Region loadAddView(){
    if(addVinylController == null){
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("addVinyl.fxml"));
      try {
        Region root = loader.load();
        addVinylController = loader.getController();
        addVinylController.init(viewModelFactory.getAddVinylViewModel(), viewHandler, root);
      }
      catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
    return addVinylController.getRoot();
  }

  public Region loadMainView(){
    if(vinylController == null){
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("vinyl.fxml"));
      try {
        Region root = loader.load();
        vinylController = loader.getController();
        vinylController.init(viewHandler, viewModelFactory.getVinylViewModel(),root);
      }
      catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
    return vinylController.getRoot();
  }

  public Region load(String id){
    return switch (id){
      case MAINVIEW -> loadMainView();
      case ADDVIEW -> loadAddView();
      default -> throw new IllegalArgumentException("Unknown view: " + id);
    };
  }
}
