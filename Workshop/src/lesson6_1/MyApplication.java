package lesson6_1;


import javafx.application.Application;
import javafx.stage.Stage;
import lesson6_1.model.Model;
import lesson6_1.model.ModelManager;
import lesson6_1.view.ViewHandler;
import lesson6_1.viewmodel.ViewModelFactory;

public class MyApplication extends Application
  {
    public void start(Stage primaryStage)
    {
      Model model = new ModelManager();
      ViewModelFactory viewModelFactory = new ViewModelFactory(model);
      ViewHandler view = new ViewHandler(viewModelFactory);

      view.start(primaryStage);
    }
  }