package uppercase.client;

import javafx.application.Application;
import javafx.stage.Stage;
import uppercase.client.core.ClientFactory;
import uppercase.client.core.ModelFactory;
import uppercase.client.core.ViewHandler;
import uppercase.client.core.ViewModelFactory;

public class UppercaseApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        ClientFactory cf = new ClientFactory();
        ModelFactory mf = new ModelFactory(cf);
        ViewModelFactory vmf = new ViewModelFactory(mf);
        ViewHandler vh = new ViewHandler(vmf);
        vh.start();
    }
}
