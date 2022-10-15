package Ex1_SimpleMVVM.viewmodel;

import Ex1_SimpleMVVM.model.DataModel;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TimestampViewModel {

    private StringProperty updateTimeStamp;
    private StringProperty numberOfUpdates;

    private DataModel model;

    public TimestampViewModel(DataModel model) {
        this.model = model;
        updateTimeStamp = new SimpleStringProperty("Last update: ");
        numberOfUpdates = new SimpleStringProperty("abc");
    }

    public void updateTimestamp() {
        updateTimeStamp.setValue("Last updated: " + model.getLastUpdateTimeStamp());
        model.increaseNumberOfUpdates();
      numberOfUpdates.setValue("abc: " + model.getNumberOfUpdates());

    }


    public StringProperty updateTimeStampProperty() {
        return updateTimeStamp;
    }

    public StringProperty updateNumber()
    {
        return numberOfUpdates;
    }
}
