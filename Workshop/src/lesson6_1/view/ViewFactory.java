package lesson6_1.view;


import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Region;
import lesson6_1.viewmodel.ViewModelFactory;

import java.io.IOError;
import java.io.IOException;

public class ViewFactory
{
  public static final String CONVERT="convert";
  public static final String LOG="log";
  private ViewHandler viewHandler;
  private ViewModelFactory viewModelFactory;
  private ConvertViewController convertViewController;
  private ShowLogViewController showLogViewController;
  public ViewFactory(ViewHandler viewHandler, ViewModelFactory viewModelFactory)
  {
    this.viewHandler=viewHandler;
    this.viewModelFactory=viewModelFactory;
  }
  public Region loadView(String id)
  {
    return switch (id){
      case "convert" -> loadConvertView();
      case "log" -> showLogView();
      default -> throw new IllegalArgumentException("unknown view " + id);
    };

  }
  public Region loadConvertView(){
    if (convertViewController == null) {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("ConvertView.fxml"));
      try {
        Region root = loader.load();
        convertViewController = loader.getController();
        convertViewController.init(viewHandler, viewModelFactory.getConvertViewModel(), root);
      } catch (IOException e) {
        throw new IOError(e);
      }
    }
    convertViewController.reset();
    return convertViewController.getRoot();
  }

  public Region showLogView()
  {

      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("ShowLog.fxml"));
      try {
        Region root = loader.load();
        showLogViewController = loader.getController();
        showLogViewController.init(viewHandler, viewModelFactory.getShowLogViewModel(), root);
      } catch (IOException e) {
        throw new IOError(e);

    }
    showLogViewController.reset();
    return showLogViewController.getRoot();
  }

}
