package ex6_TextEditor.viewmodel;

import ex6_TextEditor.model.DataModel;
import ex6_TextEditor.model.ModelFactory;
import ex6_TextEditor.viewmodel.piechart.PieChartViewModel;
import ex6_TextEditor.viewmodel.textChart.TextChartViewModel;

public class ViewModelFactory {
    private ModelFactory modelFactory;
    private PieChartViewModel pieChartViewModel;
    private TextChartViewModel textChartViewModel;

    public ViewModelFactory(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
        pieChartViewModel = new PieChartViewModel(modelFactory.getDataModel());
        textChartViewModel = new TextChartViewModel(modelFactory.getDataModel());
    }

    public PieChartViewModel getPieChartViewModel() {
        return pieChartViewModel;
    }

    public TextChartViewModel getTextChartViewModel()
    {
        return textChartViewModel;
    }
}
