package viewModel;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.TemperatureModel;
import model.temperature.Temperature;

import java.beans.PropertyChangeEvent;

public class TemperatureViewModel
{
  private StringProperty outdoorTemp;
  private StringProperty thermometer1;
  private StringProperty thermometer2;
  private StringProperty warning;
  private TemperatureModel temperatureModel;


  public TemperatureViewModel(TemperatureModel temperatureModel)
  {
    this.temperatureModel = temperatureModel;
    outdoorTemp = new SimpleStringProperty();
    thermometer1 = new SimpleStringProperty();
    thermometer2 = new SimpleStringProperty();
    warning = new SimpleStringProperty();
    temperatureModel.addPropertyChangeListener("added", evt ->tempUpdate(evt));
  }

  public void getLastTemp()
  {
    temperatureModel.getLastInsertedTemperature();
  }

  /**
   * > The function `tempUpdate()` is called by the outside thread, and it gets the
   * last inserted temperature from the database, and then updates the
   * thermometer's value
   */
  private void tempUpdate(PropertyChangeEvent evt)
  {
    Temperature t1 = temperatureModel.getLastInsertedTemperature("t1");
    Temperature t2 = temperatureModel.getLastInsertedTemperature("t2");

    //because the outside thread is trying to update javafx components, we must wrap it inside Platform.runLater()
    Platform.runLater(() ->{
    thermometer1.setValue(String.valueOf(t1));
    thermometer2.setValue(String.valueOf(t2));
    //setting external temperature to GUI
    outdoorTemp.setValue(String.valueOf(temperatureModel.getExternalTemperature()));
    });

    //set up for warning label
    double temp1 = Double.parseDouble(String.valueOf(t1));
    double temp2 = Double.parseDouble(String.valueOf(t2));
    int high = temperatureModel.highCriticalTemp();
    int low = temperatureModel.lowCriticalTemp();
    if(temp1 >= high || temp1 <= low || temp2 >= high || temp2 <= low)
    {
      Platform.runLater(()->{
      warning.setValue("Warning!! - The temperature is critical.");
      });
    }
    else
      Platform.runLater(()->{
        warning.setValue("");
      });
  }

  public StringProperty outdoorFieldProperty()
  {
    return outdoorTemp;
  }

  public StringProperty thermometer1Property()
  {
    return thermometer1;
  }

  public StringProperty thermometer2Property()
  {
    return thermometer2;
  }

  public StringProperty warningProperty()
  {
    return warning;
  }
}
