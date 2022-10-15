package ex7_BarChart.viewmodel;

import ex7_BarChart.model.ModelFactory;
import ex7_BarChart.viewmodel.barChart.BarChartViewModel;
import ex7_BarChart.viewmodel.piechart.PieChartViewModel;
import ex7_BarChart.viewmodel.textChart.TextChartViewModel;

public class ViewModelFactory {
    private ModelFactory modelFactory;
    private PieChartViewModel pieChartViewModel;
    private TextChartViewModel textChartViewModel;

    private BarChartViewModel barChartViewModel;

    public ViewModelFactory(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
        pieChartViewModel = new PieChartViewModel(modelFactory.getDataModel());
        textChartViewModel = new TextChartViewModel(modelFactory.getDataModel());
        barChartViewModel = new BarChartViewModel(modelFactory.getDataModel());
    }

    public PieChartViewModel getPieChartViewModel() {
        return pieChartViewModel;
    }

    public TextChartViewModel getTextChartViewModel()
    {
        return textChartViewModel;
    }

    public BarChartViewModel getBarChartViewModel()
    {
        return barChartViewModel;
    }
}
