package Assignment1.view;

import Assignment1.model.Vinyl;
import Assignment1.model.VinylState;
import Assignment1.viewModel.VinylViewModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;

import java.net.URL;
import java.util.ResourceBundle;

public class VinylController implements Initializable {
  @FXML
  private TableColumn<Vinyl, String> artist;
  @FXML
  private TableView<Vinyl> descriptionTable;
  @FXML
  private ListView<String> listView;
  @FXML
  private TableColumn<VinylState, String> state;
  @FXML
  private TableColumn<Vinyl, Integer> year;
  private Region root;
  private ViewHandler viewHandler;
  private VinylViewModel vinylViewModel;

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    artist.setCellValueFactory(new PropertyValueFactory<Vinyl,String>("artist"));
    year.setCellValueFactory(new PropertyValueFactory<Vinyl, Integer>("year"));
    state.setCellValueFactory(new PropertyValueFactory<VinylState, String>("state"));

  }

  public void init(ViewHandler viewHandler, VinylViewModel vinylViewModel, Region root){
    this.viewHandler = viewHandler;
    this.vinylViewModel = vinylViewModel;
    this.root = root;
    vinylViewModel.bindingListView(listView.itemsProperty());
    descriptionTable.setItems(vinylViewModel.getVinylLists());
  }

  public void onReserve() {
    Vinyl vinyl = descriptionTable.getSelectionModel().getSelectedItem();
    vinylViewModel.reserve(vinyl);
  }

  public void onBorrow() {
  }

  public void onAddVinyl() {
    viewHandler.openView(ViewFactory.ADDVIEW);
  }

  public Region getRoot() {
    return root;
  }
}
