package ex1_TimestampWtihObserver.model;

public class ModelFactory {

    private DataModel dataModel;

    public DataModel getDataModel() {
        if(dataModel == null) {
            dataModel = new DataModelManager();
        }
        return dataModel;
    }


}
