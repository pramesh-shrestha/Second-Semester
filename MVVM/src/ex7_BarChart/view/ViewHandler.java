package ex7_BarChart.view;

import ex7_BarChart.view.barChart.BarChartViewController;
import ex7_BarChart.view.piechart.PieChartController;
import ex7_BarChart.view.textChart.TextChartController;
import ex7_BarChart.viewmodel.ViewModelFactory;
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
        openView("BarChart");

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
        else if("BarChart".equals(viewToOpen))
        {
            BarChartViewController controller1 = loader.getController();
            controller1.init(viewModelFactory.getBarChartViewModel());
            stage.setTitle("Bar Chart");
        }

        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
