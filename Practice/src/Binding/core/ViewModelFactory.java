package Binding.core;

import Binding.viewmodel.ConverterViewModel;

public class ViewModelFactory
{
  private ModelFactory modelFactory;
  private ConverterViewModel viewModel;

  public ViewModelFactory(ModelFactory modelFactory)
  {
    this.modelFactory = modelFactory;
    viewModel = new ConverterViewModel(modelFactory.getSimpleTextConverter());

  }

  public ConverterViewModel getConverterViewModel()
  {
    return viewModel;
  }
}
