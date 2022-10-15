package ex1_TimestampWtihObserver.viewmodel;

import ex1_TimestampWtihObserver.model.ModelFactory;
public class ViewModelFactory {

    private TimestampViewModel timestampViewModel;

    public ViewModelFactory(ModelFactory modelFactory) {
        timestampViewModel = new TimestampViewModel(modelFactory.getDataModel());
    }

    public TimestampViewModel getTimestampViewModel() {
        return timestampViewModel;
    }
}
