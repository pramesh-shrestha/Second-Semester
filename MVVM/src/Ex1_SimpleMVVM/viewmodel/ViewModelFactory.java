package Ex1_SimpleMVVM.viewmodel;

import Ex1_SimpleMVVM.model.ModelFactory;

public class ViewModelFactory{

    private TimestampViewModel timestampViewModel;


    public ViewModelFactory(ModelFactory modelFactory) {
        timestampViewModel = new TimestampViewModel(modelFactory.getDataModel());
    }

    public TimestampViewModel getTimestampViewModel() {
        return timestampViewModel;
    }
}
