package Temperature.viewModel;

import Temperature.model.Temperature;
import Temperature.model.TemperatureModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TemperatureViewModel
{
  private TemperatureModel temperatureModel;
  private StringProperty outputLabel;
  private StringProperty filterField;
  private StringProperty filterLabel;
  private String thermometerId = null;

  public TemperatureViewModel(TemperatureModel temperatureModel)
  {
    this.temperatureModel = temperatureModel;
    outputLabel = new SimpleStringProperty();
    filterField = new SimpleStringProperty();
    filterLabel = new SimpleStringProperty();
  }

  public void getLastTemp()
  {
    temperatureModel.getLastInsertedTemperature();
  }

  public StringProperty outputLabelProperty()
  {
    return outputLabel;
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

    if(thermometerId == null)
    {
      Temperature t1 = temperatureModel.getLastInsertedTemperature("t1");
      Temperature t2 = temperatureModel.getLastInsertedTemperature("t2");
      outputLabel.setValue(t1.toString() + " \n" + t2.toString());
    }

    else if(thermometerId.equals("t1"))
    {
      Temperature t = temperatureModel.getLastInsertedTemperature("t1");
      outputLabel.setValue(t.toString());
    }
    else if(thermometerId.equals("t2"))
    {
      Temperature t = temperatureModel.getLastInsertedTemperature("t2");
      outputLabel.setValue(t.toString());
    }



  }

  public void filter()
  {
    thermometerId = filterField.getValue();
    if (thermometerId == null)
    {
      filterLabel.setValue("All");
      update();
    }
    else
    {
      filterLabel.setValue(thermometerId);
      update();
    }
    filterField.set(null);

  }
}
