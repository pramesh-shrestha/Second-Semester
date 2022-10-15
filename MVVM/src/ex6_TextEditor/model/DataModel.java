package ex6_TextEditor.model;

public interface DataModel {
    double[] getDataValues();
    String getLastUpdateTimeStamp();
    void saveDataValues(double x, double y, double z);
}
