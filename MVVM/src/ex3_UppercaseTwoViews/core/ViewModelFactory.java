package ex3_UppercaseTwoViews.core;

import ex3_UppercaseTwoViews.view.log.LogViewModel;
import ex3_UppercaseTwoViews.view.uppercase.UppercaseViewModel;

public class ViewModelFactory
{
  private LogViewModel logViewModel;
  private UppercaseViewModel uppercaseViewModel;
  private ModelFactory modelFactory;

  //constructor
  public ViewModelFactory(ModelFactory modelFactory)
  {
    this.modelFactory = modelFactory;
    uppercaseViewModel = new UppercaseViewModel(modelFactory.getTextConverter());
    logViewModel = new LogViewModel(modelFactory.getTextConverter());

  }

  public UppercaseViewModel getUppercaseViewModel()
  {
    return uppercaseViewModel;
  }

  public LogViewModel getLogViewModel()
  {
    return logViewModel;
  }



}
