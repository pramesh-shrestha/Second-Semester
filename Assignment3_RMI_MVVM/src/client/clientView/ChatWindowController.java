package client.clientView;

import client.clientViewModel.ChatWindowViewModel;
import client.core.ViewHandler;
import client.core.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ChatWindowController implements ViewController {
  @FXML
  private ListView<String> chatAreaField;
  @FXML
  private TextField textField;
  @FXML
  private ListView<String> userListView;

  @FXML
  private Label userNameLabel;
  private ChatWindowViewModel chatWindowViewModel;
  private ViewHandler viewHandler;
  private Boolean bool = true;

  @Override public void init(ViewHandler viewHandler,
      ViewModelFactory viewModelFactory) {
    this.viewHandler = viewHandler;
    chatWindowViewModel = viewModelFactory.getChatWindowViewModel();
    chatAreaField.setItems(chatWindowViewModel.getMessages());
    textField.textProperty().bindBidirectional(chatWindowViewModel.textProperty());
    userListView.setItems(chatWindowViewModel.getUserList());
    userNameLabel.textProperty().bind(chatWindowViewModel.userNameProperty());
  }

  @FXML public void onSendButton() {
    if (bool)
      chatWindowViewModel.sendMessage();

      //private message
    else {
      String userName = userListView.getSelectionModel().getSelectedItem();
      if (chatWindowViewModel.sendPrivateMessage(userName))

        //      chatAreaField = new ListView<>();
        chatAreaField.setItems(chatWindowViewModel.getAllPrivateMsg());
      System.out.println(chatWindowViewModel.getAllPrivateMsg());

    }

  }

  //private message
  @FXML public void onSelectButton() {
    bool = false;
  }

  //private message

  public void unSelect() {
    int user = userListView.getSelectionModel().getSelectedIndex();
    if (userListView.getSelectionModel().isSelected(user)) {
      userListView.getSelectionModel().clearSelection(user);
    }
  }

  //private message
  public void onUnselectButton() {
    unSelect();
    bool = true;
  }
}
