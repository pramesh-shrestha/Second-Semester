package timestamp.client;

import javafx.application.Application;
import javafx.stage.Stage;
import timestamp.client.model.ModelFactory;
import timestamp.client.network.ClientFactory;
import timestamp.client.view.ViewHandler;
import timestamp.client.viewmodel.ViewModelFactory;



public class TimestampApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        ClientFactory cf = new ClientFactory();
        ModelFactory mf = new ModelFactory(cf);
        ViewModelFactory viewModelFactory = new ViewModelFactory(mf);
        ViewHandler viewHandler = new ViewHandler(viewModelFactory);
        viewHandler.start();

    }

}
