package ex2_TemperatureWithObserver.viewModel;

import ex2_TemperatureWithObserver.model.Temperature;
import ex2_TemperatureWithObserver.model.TemperatureModel;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TemperatureViewModel
{
  private TemperatureModel temperatureModel;
  private StringProperty outputLabel1;
  private StringProperty outputLabel2;
  private StringProperty filterField;
  private StringProperty filterLabel;


  public TemperatureViewModel(TemperatureModel temperatureModel)
  {
    this.temperatureModel = temperatureModel;
    outputLabel1 = new SimpleStringProperty();
    outputLabel2 = new SimpleStringProperty();
    filterField = new SimpleStringProperty();
    filterLabel = new SimpleStringProperty();
    temperatureModel.addPropertyChangeListener("added", evt -> update());
  }

  public void getLastTemp()
  {
    temperatureModel.getLastInsertedTemperature();
  }

  public StringProperty outputLabel1Property()
  {
    return outputLabel1;
  }
  public StringProperty outputLabel2Property()
  {
    return outputLabel2;
  }

  public StringProperty filterFieldProperty()
  {
    return filterField;
  }

  public StringProperty filterLabelProperty()
  {
    return filterLabel;
  }

  public void update()
  {
    Temperature t1 = temperatureModel.getLastInsertedTemperature("t1");
    Temperature t2 = temperatureModel.getLastInsertedTemperature("t2");
    //because the outside thread is trying to update javafx components, we must wrap it inside Platform.runLater()
    Platform.runLater(() -> {
      outputLabel1.setValue(t1.toString());
      outputLabel2.setValue(t2.toString());
    });

  }
}
