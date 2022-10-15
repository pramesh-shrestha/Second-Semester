package ex4_Thermometer.viewModel;

import ex4_Thermometer.mediator.TemperatureModel;
import ex4_Thermometer.model.TemperatureList;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TemperatureViewModel
{
  private TemperatureModel temperatureModel;
  private StringProperty outputLabel;
  private StringProperty filterLabel;
  private StringProperty filterField;



  public TemperatureViewModel(TemperatureModel model)
  {
    temperatureModel = model;
    outputLabel = new SimpleStringProperty();
    filterLabel = new SimpleStringProperty("");
    filterField = new SimpleStringProperty();

  }
  public void getValue()
  {
    TemperatureList t = temperatureModel.getLastInsertedTemperature();
    if (t != null)
    {
      outputLabel.setValue(t.toString());
    }
    else
    {
      outputLabel.setValue("No data");
    }
  }

  public void updateThermometerId()
  {
    if (filterField.get().equals("") || filterField.get() == null)  {
      outputLabel.setValue(temperatureModel.getLastInsertedTemperature().toString());
    }

    if (filterField.get().equalsIgnoreCase("t1"))
    {
      outputLabel.setValue(temperatureModel.getLastInsertedTemperature("t1").toString());
    }
    if(filterField.get().equalsIgnoreCase("t2"))
    {
      outputLabel.setValue(temperatureModel.getLastInsertedTemperature("t2").toString());
    }
    filterField.set("");
  }

  public StringProperty outputLabelProperty()
  {
    return outputLabel;
  }

  public StringProperty filterLabelProperty()
  {
    return filterLabel;
  }

  public StringProperty filterFieldProperty()
  {
    return filterField;
  }

}
