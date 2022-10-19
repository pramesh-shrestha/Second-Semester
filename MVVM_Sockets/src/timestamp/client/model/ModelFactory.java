package timestamp.client.model;


import timestamp.client.network.ClientFactory;
import timestamp.server.model.DataModel;

public class ModelFactory {

    private DataModel dataModel;
    private ClientFactory cf;

    public ModelFactory(ClientFactory cf)
    {
        this.cf = cf;
    }

    public DataModel getDataModel() {
        if(dataModel == null) {
            dataModel = new DataModelManager(cf.getClient());
        }
        return dataModel;
    }


}
