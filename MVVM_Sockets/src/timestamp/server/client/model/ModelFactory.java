package timestamp.server.client.model;


import timestamp.server.client.network.ClientFactory;

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
