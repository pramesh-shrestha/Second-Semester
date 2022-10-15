package ex5_PieChart;

import ex5_PieChart.model.DataModelManager;
import ex5_PieChart.model.ModelFactory;
import ex5_PieChart.view.ViewHandler;
import ex5_PieChart.viewmodel.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;
import java.util.Random;

@SuppressWarnings("ALL")
public class PieChartApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
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
