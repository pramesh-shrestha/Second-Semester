package ex2_uppercase_converter;

import ex2_uppercase_converter.core.ModelFactory;
import ex2_uppercase_converter.core.ViewHandler;
import ex2_uppercase_converter.core.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class UppercaseApp extends Application
{
  @Override public void start(Stage stage)
  {
    ModelFactory modelFactory = new ModelFactory();
    ViewModelFactory viewModelFactory = new ViewModelFactory(modelFactory);
    ViewHandler viewHandler = new ViewHandler(viewModelFactory);
    viewHandler.start();
  }
}
