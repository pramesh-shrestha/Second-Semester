package ex6_TextEditor.viewmodel.textChart;

import ex6_TextEditor.model.DataModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TextChartViewModel
{
  private StringProperty x;
  private StringProperty y;
  private StringProperty z;
  private StringProperty timeStamp;
  private DataModel dataModel;

  public TextChartViewModel(DataModel dataModel)
  {
    this.dataModel = dataModel;
    x = new SimpleStringProperty();
    y = new SimpleStringProperty();
    z = new SimpleStringProperty();
    timeStamp = new SimpleStringProperty();
  }
  public void updateData()
  {
    double[] dataValues = dataModel.getDataValues();
    x.setValue(dataValues[0] + "");
    y.setValue(dataValues[1] + "");
    z.setValue(dataValues[2] + "");
    timeStamp.setValue(dataModel.getLastUpdateTimeStamp());

  }

  public void saveData()
  {
    //We need to translate it to double because the view understands Strings, but our Model understands double
    double x = Double.parseDouble(xProperty().getValue());
    double y = Double.parseDouble(yProperty().getValue());
    double z = Double.parseDouble(zProperty().getValue());
    dataModel.saveDataValues(x,y,z);
  }



  public StringProperty xProperty()
  {
    return x;
  }


  public StringProperty yProperty()
  {
    return y;
  }

  public StringProperty zProperty()
  {
    return z;
  }

  public String getTimeStamp()
  {
    return timeStamp.get();
  }

  public StringProperty timeStampProperty()
  {
    return timeStamp;
  }
}

