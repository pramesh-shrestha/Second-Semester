package ex7_BarChart.view.barChart;

import ex7_BarChart.viewmodel.barChart.BarChartViewModel;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

public class BarChartViewController
{

  @FXML
  private Label timeStampLabel;
  @FXML
  BarChart barChart;
  private XYChart.Data<String,Double> x = new XYChart.Data<>("X", 0.0);
  private XYChart.Data<String,Double> y = new XYChart.Data<>("Y", 0.0);
  private XYChart.Data<String,Double> z = new XYChart.Data<>("Z", 0.0);

  private BarChartViewModel barChartViewModel;

  public void init(BarChartViewModel barChartViewModel)
  {

    this.barChartViewModel = barChartViewModel;
    x.YValueProperty().bind(barChartViewModel.xProperty());
    y.YValueProperty().bind(barChartViewModel.yProperty());
    z.YValueProperty().bind(barChartViewModel.zProperty());
    timeStampLabel.textProperty().bind(barChartViewModel.timeStampLabelProperty());

    XYChart.Series redSeries = new XYChart.Series();
    redSeries.setName("X");
    redSeries.getData().add(x);
    barChart.getData().add(redSeries);

    XYChart.Series yellowSeries = new XYChart.Series<>();
    yellowSeries.setName("Y");
    yellowSeries.getData().add(y);
    barChart.getData().add(yellowSeries);

    XYChart.Series greenSeries = new XYChart.Series();
    greenSeries.setName("Z");
    greenSeries.getData().add(z);
    barChart.getData().add(greenSeries);


  }

  public void onUpdateButton()
  {
    barChartViewModel.updateBarChart();
  }
}

