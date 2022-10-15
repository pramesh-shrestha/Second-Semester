package ex1_TimestampWtihObserver.view;

import ex1_TimestampWtihObserver.viewmodel.TimestampViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
//import viewmodel.ViewModelFactory;

public class TimestampController {

    @FXML
    Label eventLabel;
    @FXML
    Label numberOfUpdates;
    @FXML
    private Circle circle;
    @FXML
    private Label counter;


    private TimestampViewModel viewModel;

    public TimestampController() {
    }

    public void init(TimestampViewModel viewModel) {
        this.viewModel = viewModel;
        eventLabel.textProperty().bind(viewModel.updateTimeStampProperty());
        numberOfUpdates.textProperty().bind(viewModel.numberOfUpdatesProperty());
        circle.fillProperty().bind(viewModel.circleProperty());
        counter.textProperty().bind(viewModel.counterLabelProperty());
    }

}
