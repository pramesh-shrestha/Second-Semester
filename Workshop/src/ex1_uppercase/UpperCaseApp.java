package ex1_uppercase;

import ex1_uppercase.Model.Model;
import ex1_uppercase.Model.ModelManager;
import ex1_uppercase.View.ViewHandler;
import ex1_uppercase.ViewModel.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class UpperCaseApp extends Application
{

  @Override public void start(Stage stage) throws Exception
  {
    Model model = new ModelManager();
    ViewModelFactory viewModelFactory = new ViewModelFactory(model);
    ViewHandler view = new ViewHandler(viewModelFactory);
    view.start(stage);

  }
}
