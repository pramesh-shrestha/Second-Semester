package ex3_UppercaseTwoViews;

import ex3_UppercaseTwoViews.core.ModelFactory;
import ex3_UppercaseTwoViews.core.ViewHandler;
import ex3_UppercaseTwoViews.core.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class UppercaseApp extends Application
{
  @Override public void start(Stage stage) throws Exception
  {
    ModelFactory modelFactory = new ModelFactory();
    ViewModelFactory viewModelFactory = new ViewModelFactory(modelFactory);
    ViewHandler viewHandler = new ViewHandler(viewModelFactory);
    viewHandler.start();
  }
}
