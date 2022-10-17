package Binding;

import Binding.core.ModelFactory;
import Binding.core.ViewHandler;
import Binding.core.ViewModelFactory;

import javafx.application.Application;

import javafx.stage.Stage;



public class SimpleApp extends Application
{
  @Override public void start(Stage stage) throws Exception
  {
    ModelFactory modelFactory = new ModelFactory();
    ViewModelFactory viewModelFactory = new ViewModelFactory(modelFactory);
    ViewHandler viewHandler = new ViewHandler(viewModelFactory);
    viewHandler.start();
  }
}
