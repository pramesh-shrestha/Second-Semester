package ex6_TextEditor;

import ex6_TextEditor.model.DataModelManager;
import ex6_TextEditor.model.ModelFactory;
import ex6_TextEditor.view.ViewHandler;
import ex6_TextEditor.viewmodel.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Random;

@SuppressWarnings("ALL")
public class PieChartApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        ModelFactory mf = new ModelFactory();
        ViewModelFactory viewModelFactory = new ViewModelFactory(mf);
        ViewHandler viewHandler = new ViewHandler(viewModelFactory);
        viewHandler.start();

        runAutoUpdate((DataModelManager) mf.getDataModel());
    }

    private void runAutoUpdate(DataModelManager m) {
        Thread thread = new Thread(() -> {
            Random r = new Random();
            while (true) {
                m.recalculateData();
                try {
                    Thread.sleep(r.nextInt(5000) + 10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setDaemon(true);
        thread.start() ;
    }
}
