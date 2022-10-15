package ex6_TextEditor.view;

import ex6_TextEditor.view.piechart.PieChartController;
import ex6_TextEditor.view.textChart.TextChartController;
import ex6_TextEditor.viewmodel.ViewModelFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler {

    private ViewModelFactory viewModelFactory;

    public ViewHandler(ViewModelFactory viewModelFactory) {
        this.viewModelFactory = viewModelFactory;
    }

    public void start() throws Exception{
        openView("PieChart");
        openView("TextChart");
    }

    public void openView(String viewToOpen) throws IOException {
        Stage stage = new Stage();
        Scene scene = null;
        FXMLLoader loader = new FXMLLoader();
        Parent root = null;

        loader.setLocation(getClass().getResource(viewToOpen.toLowerCase()+"/"+ viewToOpen +"View.fxml"));
        root = loader.load();
        if("PieChart".equals(viewToOpen)) {
            PieChartController view = loader.getController();
            view.init(viewModelFactory.getPieChartViewModel());
            stage.setTitle("Pie Chart");
        }
        else if("TextChart".equals(viewToOpen))
        {
            TextChartController controller = loader.getController();
            controller.init(viewModelFactory.getTextChartViewModel());
            stage.setTitle("Text chart");
        }

        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
