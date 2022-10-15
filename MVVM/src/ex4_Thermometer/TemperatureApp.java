package ex4_Thermometer;

import ex4_Thermometer.core.ModelFactory;
import ex4_Thermometer.core.ViewHandler;
import ex4_Thermometer.core.ViewModelFactory;
import ex4_Thermometer.external.Thermometer;
import javafx.application.Application;
import javafx.stage.Stage;

public class TemperatureApp extends Application
{
  @Override public void start(Stage stage) throws Exception
  {
    ModelFactory mf = new ModelFactory();
    ViewModelFactory vmf = new ViewModelFactory(mf);
    ViewHandler vh = new ViewHandler(vmf);
    vh.start();
    Thread t1 = new Thread(new Thermometer(mf.getTemperatureModel(), "t1",15, 1));
    Thread t2 = new Thread(new Thermometer(mf.getTemperatureModel(),"t2",15, 7));
    t1.start();
    t2.start();
  }
}
