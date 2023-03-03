package uppercaseWS;

import javafx.application.Application;
import javafx.stage.Stage;
import uppercaseWS.model.Converter;
import uppercaseWS.model.IModel;
import uppercaseWS.model.ModelManager;
import uppercaseWS.view.ViewHandler;
import uppercaseWS.viewmodel.ViewModelFactory;

public class MyApplication extends Application {
  @Override
  public void start(Stage stage)  {
    Converter converter = new Converter();
    IModel model = new ModelManager(converter);
    ViewModelFactory viewModelFactory = new ViewModelFactory(model);
    ViewHandler viewHandler = new ViewHandler(viewModelFactory);
    viewHandler.start(stage);
  }
}
