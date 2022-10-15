package ex7_BarChart.view.textChart;

import ex7_BarChart.viewmodel.textChart.TextChartViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TextChartController
{
  @FXML
  private Label timeStampLabel;
  @FXML
  private TextField xTextField;
  @FXML
  private TextField yTextField;
  @FXML
  private TextField zTextField;
  private TextChartViewModel textChartViewModel;

  public void init(TextChartViewModel textChartViewModel)
  {
   this.textChartViewModel = textChartViewModel;
   xTextField.textProperty().bindBidirectional(textChartViewModel.xProperty());
   yTextField.textProperty().bindBidirectional(textChartViewModel.yProperty());
   zTextField.textProperty().bindBidirectional(textChartViewModel.zProperty());
   timeStampLabel.textProperty().bind(textChartViewModel.timeStampProperty());
  }
  public void onUpdateAction()
  {
    textChartViewModel.updateData();
  }

  public void onSaveAction()
  {
    textChartViewModel.saveData();
  }
}

