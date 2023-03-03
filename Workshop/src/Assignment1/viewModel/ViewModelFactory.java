package Assignment1.viewModel;

import Assignment1.model.IModel;

public class ViewModelFactory {
  private AddVinylViewModel addVinylViewModel;
  private VinylViewModel vinylViewModel;

  public ViewModelFactory(IModel model) {
    addVinylViewModel = new AddVinylViewModel(model);
    vinylViewModel = new VinylViewModel(model);
  }

  public AddVinylViewModel getAddVinylViewModel() {
    return addVinylViewModel;
  }

  public VinylViewModel getVinylViewModel() {
    return vinylViewModel;
  }
}
