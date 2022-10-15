package ex7_BarChart.viewmodel.barChart;

import ex7_BarChart.model.DataModel;
import javafx.beans.property.*;
import javafx.beans.value.ObservableValue;

public class BarChartViewModel
{
  private DoubleProperty x;
  private DoubleProperty y;
  private DoubleProperty z;
  private StringProperty timeStampLabel;
  private DataModel dataModel;

  public BarChartViewModel(DataModel dataModel)
  {
    this.dataModel = dataModel;
    x = new SimpleDoubleProperty();
    y = new SimpleDoubleProperty();
    z = new SimpleDoubleProperty();
    timeStampLabel = new SimpleStringProperty();
  }
  public void updateBarChart()
  {
    double[] vals = dataModel.getDataValues();
    x.setValue(vals[0]);
    y.setValue(vals[1]);
    z.setValue(vals[2]);
    timeStampLabel.setValue(dataModel.getLastUpdateTimeStamp());

  }

  public StringProperty timeStampLabelProperty()
  {
    return timeStampLabel;
  }

  public ObservableValue xProperty()
  {
    return x;

  }

  public ObservableValue yProperty()
  {
    return y;
  }

  public ObservableValue zProperty()
  {
    return z;
  }
}
