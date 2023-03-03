package uppercaseWS.viewmodel;

import uppercaseWS.model.IModel;

public class ViewModelFactory {
  private ConvertViewModel convertViewModel;


  public ViewModelFactory(IModel model){
    convertViewModel = new ConvertViewModel(model);
  }

  public ConvertViewModel getConvertViewModel(){
    return convertViewModel;
  }
}
