package uppercaseWithLogs.core;

import uppercaseWithLogs.viewModel.LogViewModel;
import uppercaseWithLogs.viewModel.UpperCaseViewModel;

public class ViewModelFactory
{
  private ModelFactory modelFactory;
  private UpperCaseViewModel upperCaseViewModel;
  private LogViewModel logViewModel;

  public ViewModelFactory(ModelFactory modelFactory)
  {
    this.modelFactory = modelFactory;
    upperCaseViewModel = new UpperCaseViewModel(modelFactory.getTextConverterModel());
    logViewModel = new LogViewModel(modelFactory.getTextConverterModel());

  }

  public UpperCaseViewModel getUpperCaseVM()
  {
    return upperCaseViewModel;
  }

  public LogViewModel getLogViewModel()
  {
    return logViewModel;
  }
}
