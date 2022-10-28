package client.clientViewModel;

import client.clientModel.ClientChatModel;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.Msg;

import java.beans.PropertyChangeEvent;
import java.util.List;

public class ChatWindowViewModel
{

  private StringProperty text;
  private ObservableList<String> userList;
  private ObservableList<String> messages;
  private ObservableList<String> privateMessages;
  private StringProperty userName;
  private ClientChatModel clientChatModel;
  private String user = "";


  public ChatWindowViewModel(ClientChatModel clientChatModel)
  {

    privateMessages = FXCollections.observableArrayList();

    this.clientChatModel = clientChatModel;
    text = new SimpleStringProperty();
    //we get all the usernames from the server that are logged in
    List<String> usernames = clientChatModel.getAllUsername();
    //we add these usernames to observableArray list so that the new client that joins the chat can see all those previously online users
    userList = FXCollections.observableArrayList(usernames);
    //we get all the messages of clients from the server
    List<String> messageList = clientChatModel.getAllMessages();
    //we add this messageList to observableArrayList so that the new client that joins the chat can get all the older messages
    messages = FXCollections.observableArrayList(messageList);
    userName = new SimpleStringProperty();
    //adding two events that this listener(ChatWindowViewModel) listens to whenever something changes in the clientChatModel
    clientChatModel.addPropertyChangeListener("userLoggedIn", this::addToListView);
    clientChatModel.addPropertyChangeListener("newMessage", this::onNewMessage);
    clientChatModel.addPropertyChangeListener("privateMessage", this::onPrivateMessage);
  }

  private void onPrivateMessage(PropertyChangeEvent event)
  {
    String message = (String) event.getNewValue();
    Platform.runLater(()->{
      privateMessages.add(message);
    });
  }

  private void onNewMessage(PropertyChangeEvent event)
  {
    Msg message = (Msg) event.getNewValue();
    if(message.getUser().equals(user))
    {
      Platform.runLater(()->{
        messages.add("Me : " + message.getText());
      });
    }
    else
    {
    Platform.runLater(()->{
       messages.add(message.getUser() + " : " + message.getText());
        });
    }
  }

  private void addToListView(PropertyChangeEvent evt)
  {
    String user = (String) evt.getNewValue();
    Platform.runLater(()->{
      userList.add(user);
    });
  }

  public StringProperty textProperty()
  {
    return text;
  }

  public ObservableList<String> getUserList()
  {
    return userList;
  }

  public StringProperty userNameProperty()
  {
    return userName;
  }

  public void sendMessage()
  {
    String msg = text.get();
    clientChatModel.sendMessage(user,msg);
    text.set("");
  }

  public ObservableList<String> getMessages()
  {
    return messages;
  }

  public Boolean sendPrivateMessage(String userName)
  {
    String msg = text.get();
    return clientChatModel.sendPrivateMessage(userName,msg);
  }
  //for private messages
  public ObservableList<String> getAllPrivateMsg()
  {
    List<String> privateMessage = clientChatModel.getAllPrivateMessages();
//    privateMessages.add(privateMessage.toString());
    return privateMessages;
  }

  //login username
  public void setUserName(String user)
  {
    this.user = user;
  }
}
