package viewModel;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.TemperatureModel;

public class HeaterPowerViewModel
{
  private StringProperty powerPosition;
  private StringProperty powerUpDown;
  private TemperatureModel temperatureModel;

  public HeaterPowerViewModel(TemperatureModel temperatureModel)
  {
    this.temperatureModel = temperatureModel;
    powerPosition = new SimpleStringProperty("Off");
    powerUpDown = new SimpleStringProperty("0");
    temperatureModel.addPropertyChangeListener("powerPosition", evt -> changePowerPosition());
  }


  /**
   * The method changes the power position of the radiator.
   */
  private void changePowerPosition()
  {
    String power = String.valueOf(temperatureModel.getRadiator().getPower());
    int powerPos = Integer.parseInt(power);
    if(powerPos == 0)
      powerPosition.setValue("Off");
    else if(powerPos == 1)
      powerPosition.setValue("Low");
    else if(powerPos == 2)
      powerPosition.setValue("Medium");
    else if(powerPos == 3)
      powerPosition.setValue("High");
    //setting value of upDown text field
    powerUpDown.setValue(power);

    if(Integer.parseInt(power) == 3)
    {
      //running new thread because when position is at 3, the position goes back to 2 after 10 seconds.
      //therefore, to set new value to the GUI, new thread is started. The reason it is made slept for 11 secs
      //is that, we can display new power position to the GUI.
      new Thread(()->{
        try
        {
          Thread.sleep(31000);
          String power1 = String.valueOf(temperatureModel.getRadiator().getPower());

          Platform.runLater(()->{
            //This is an external thread that tries to update JavaFx component, that is why it must be wrapped inside Platform.runLater().
            powerPosition.setValue(power1);

          });
          powerUpDown.setValue(power1);
        }
        catch (InterruptedException e)
        {
          throw new RuntimeException(e);
        }
      }).start();
    }
  }

  /**
   * This function returns a StringProperty object that represents the
   * powerPosition property.
   *
   * @return A StringProperty object.
   */
  public StringProperty powerPositionProperty()
  {
    return powerPosition;
  }

  /**
   * > This function returns the powerUpDown property
   *
   * @return A StringProperty
   */
  public StringProperty powerUpDownProperty()
  {
    return powerUpDown;
  }

  /**
   * When the up button is pressed, the radiator is turned up and the radiator is
   * called.
   */
  public void upButton()
  {
    temperatureModel.getRadiator().turnUp();
    temperatureModel.radiator();
  }

  /**
   * When the down button is pressed, the radiator is turned down and the radiator
   * is updated.
   */
  public void downButton()
  {
    temperatureModel.getRadiator().turnDown();
    temperatureModel.radiator();

  }
}
