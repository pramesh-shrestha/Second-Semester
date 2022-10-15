package ex2_uppercase_converter.core;

import ex2_uppercase_converter.view.UppercaseViewModel;

public class ViewModelFactory
{
  private UppercaseViewModel uppercaseViewModel;
  private ModelFactory modelFactory;

  //constructor
  public ViewModelFactory(ModelFactory modelFactory)
  {
    this.modelFactory = modelFactory;
  }

  public UppercaseViewModel getUppercaseViewModel()
  {
    //First checking if uppercaseViewModel is null, and if it is instantiated and then return
    //e. If this method is called multiple times, the same instance is returned every time, instead of creating a new one.
    if(uppercaseViewModel == null)
    {
      uppercaseViewModel = new UppercaseViewModel(modelFactory.getTextConverter());
    }
    return uppercaseViewModel;
  }
}
