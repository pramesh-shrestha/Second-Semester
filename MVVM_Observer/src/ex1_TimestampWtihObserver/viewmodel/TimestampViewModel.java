package ex1_TimestampWtihObserver.viewmodel;

import ex1_TimestampWtihObserver.model.DataModel;
import ex1_TimestampWtihObserver.model.PropertyChangeSubject;
import javafx.application.Platform;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.paint.Paint;

public class TimestampViewModel {

    private StringProperty updateTimeStamp;

    private StringProperty numberOfUpdates;

    private DataModel model;
    private Property<Paint> circle;
    private StringProperty counterLabel;

    public TimestampViewModel(DataModel model) {
        this.model = model;
        updateTimeStamp = new SimpleStringProperty("Last update: ");
        numberOfUpdates=new SimpleStringProperty("0");
        circle = new SimpleObjectProperty<>();
        counterLabel = new SimpleStringProperty();
        //Here we don't need to type cast because DataModel now extends the PropertyChangeSubject
        ((PropertyChangeSubject) model).addPropertyChangeListener("Updated", evt -> propertyChangeUpdateTimestamp());
        model.addPropertyChangeListener("Green", evt -> propertyChangeGreen());
        model.addPropertyChangeListener("Red", evt -> propertyChangeRed());

    }

    private void propertyChangeRed()
    {
        circle.setValue(Paint.valueOf("#FF0000"));
    }

    private void propertyChangeGreen()
    {
        circle.setValue(Paint.valueOf("#77DD77"));
    }

    public void propertyChangeUpdateTimestamp() {
        model.increaseNumberOfUpdates();
        Platform.runLater(() -> {
            updateTimeStamp.setValue("Last updated: " + model.getLastUpdateTimeStamp());
            numberOfUpdates.setValue("Number of updates: " + model.getNumberOfUpdates());
            counterLabel.setValue("Counter: " + model.getCount());
        });
    }

    public StringProperty updateTimeStampProperty() {
        return updateTimeStamp;
    }

    public StringProperty numberOfUpdatesProperty() {
        return numberOfUpdates;
    }

    public Property<Paint> circleProperty()
    {
        return circle;
    }


    public StringProperty counterLabelProperty()
    {
        return counterLabel;
    }
}
