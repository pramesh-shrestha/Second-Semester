package Temperature;

import Temperature.core.ModelFactory;
import Temperature.core.ViewHandler;
import Temperature.core.ViewModelFactory;
import Temperature.external.Thermometer;
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

    //creating Thread of Thermometer
    Thermometer thermometer1 = new Thermometer(mf.getTemperatureModel(), "t1",0.0,1);
    Thermometer thermometer2 = new Thermometer(mf.getTemperatureModel(), "t2",0.0,7);
    Thread t1 = new Thread(thermometer1);
    Thread t2 = new Thread(thermometer2);
    t1.start();
    t2.start();

  }
}
