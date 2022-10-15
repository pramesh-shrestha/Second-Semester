package ex7_BarChart.model;

public interface DataModel {
    double[] getDataValues();
    String getLastUpdateTimeStamp();
    void saveDate(double[] data);


}
