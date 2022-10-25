package timestamp.server.client;

import javafx.application.Application;
import javafx.stage.Stage;
import timestamp.server.client.model.ModelFactory;
import timestamp.server.client.network.ClientFactory;
import timestamp.server.client.view.ViewHandler;
import timestamp.server.client.viewmodel.ViewModelFactory;

public class TimestampApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        ClientFactory clientFactory = new ClientFactory();
        ModelFactory modelFactory = new ModelFactory(clientFactory);
        ViewModelFactory vmf = new ViewModelFactory(modelFactory);
        ViewHandler viewHandler = new ViewHandler(vmf);
        viewHandler.start();

    }

}
