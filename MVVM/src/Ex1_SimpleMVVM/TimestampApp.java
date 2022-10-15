package Ex1_SimpleMVVM;

import Ex1_SimpleMVVM.model.DataModelManager;
import Ex1_SimpleMVVM.model.ModelFactory;
import Ex1_SimpleMVVM.view.ViewHandler;
import Ex1_SimpleMVVM.viewmodel.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

//import model.ModelFactory;

//import viewmodel.ViewModelFactory;

import java.util.Random;

@SuppressWarnings("ALL")
public class TimestampApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
//        DataModel model = new DataModelManager();
//        TimestampViewModel viewModel =new TimestampViewModel(model);
//        ViewHandler viewHandler = new ViewHandler(stage, viewModel);
        ModelFactory mf = new ModelFactory();
        ViewModelFactory viewModelFactory = new ViewModelFactory(mf);
        ViewHandler viewHandler = new ViewHandler(stage, viewModelFactory);
        viewHandler.start();

        runAutoUpdate((DataModelManager) mf.getDataModel());
    }

    private void runAutoUpdate(DataModelManager m) {
        Thread thread = new Thread(() -> {
            Random r = new Random();
            while (true) {
                m.recalculateData();
                try {
                    Thread.sleep(r.nextInt(500) + 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setDaemon(true);
        thread.start() ;
    }
}
