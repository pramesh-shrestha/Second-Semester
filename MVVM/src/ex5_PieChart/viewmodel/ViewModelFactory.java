package ex5_PieChart.viewmodel;

import ex5_PieChart.model.ModelFactory;
import ex5_PieChart.viewmodel.piechart.PieChartViewModel;


public class ViewModelFactory {

    private PieChartViewModel pieChartViewModel;

    public ViewModelFactory(ModelFactory modelFactory) {
        pieChartViewModel = new PieChartViewModel(modelFactory.getDataModel());
    }

    public PieChartViewModel getPieChartViewModel() {
        return pieChartViewModel;
    }
}
