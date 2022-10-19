package uppercaseWithLogs;

import javafx.application.Application;
import javafx.stage.Stage;
import uppercaseWithLogs.core.ModelFactory;
import uppercaseWithLogs.core.ViewHandler;
import uppercaseWithLogs.core.ViewModelFactory;

public class UppercaseApp extends Application
{

  @Override
  public void start(Stage stage) throws Exception
  {
    ModelFactory mf = new ModelFactory();
    ViewModelFactory vmf = new ViewModelFactory(mf);
    ViewHandler vh = new ViewHandler(vmf);
    vh.start();
  }
}
