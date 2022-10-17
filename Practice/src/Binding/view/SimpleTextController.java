package Binding.view;

import Binding.core.ViewHandler;
import Binding.viewmodel.ConverterViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SimpleTextController
{
  @FXML
  private TextField text1Field;

  @FXML
  private TextField text2Field;

  private ConverterViewModel converterViewModel;
  private ViewHandler viewHandler;

  public void init(ViewHandler viewHandler, ConverterViewModel converterViewModel )
  {
    this.viewHandler = viewHandler;
    this.converterViewModel =converterViewModel;
    text1Field.textProperty().bindBidirectional(converterViewModel.Text1Property());
    text2Field.textProperty().bind(converterViewModel.Text2Property());
  }


  public void onSubmit(ActionEvent actionEvent)
  {
    converterViewModel.convert();
  }
}

