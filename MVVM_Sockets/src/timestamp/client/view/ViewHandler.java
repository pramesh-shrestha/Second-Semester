package timestamp.client.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import timestamp.client.viewmodel.ViewModelFactory;

import java.io.IOException;


public class ViewHandler {
    private ViewModelFactory viewModelFactory;

    public ViewHandler(ViewModelFactory viewModelFactory) {
        this.viewModelFactory = viewModelFactory;
        System.out.println("i am here");
    }

    public void start(){

        openView();
    }

    private void openView()  {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource( "TimestampView.fxml"));
        try
        {
           Parent root = loader.load();
            TimestampController controller = loader.getController();
            controller.init(viewModelFactory.getTimestampViewModel());
            stage.setTitle("Show timestamp");
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }

    }
}
