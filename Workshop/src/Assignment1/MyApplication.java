package Assignment1;


import Assignment1.model.IModel;
import Assignment1.model.Model;
import Assignment1.view.ViewHandler;
import Assignment1.viewModel.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;


public class MyApplication extends Application
  {
    public void start(Stage primaryStage)
    {
      IModel model = new Model();
      ViewModelFactory viewModelFactory = new ViewModelFactory(model);
      ViewHandler view = new ViewHandler(viewModelFactory);

      view.start();
    }
  }