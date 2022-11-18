package client.clientView;

import client.clientViewModel.UserLoginViewModel;
import client.core.ViewHandler;
import client.core.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class UserLoginController implements ViewController
{
  @FXML
  private Label errorLabel;
  @FXML
  private PasswordField loginPasswordField;
  @FXML
  private TextField loginUsernameField;
  private ViewHandler viewHandler;
  private UserLoginViewModel userLoginViewModel;

  @Override public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory)
  {
    this.viewHandler = viewHandler;
    userLoginViewModel = viewModelFactory.getUserLoginViewModel();
    errorLabel.textProperty().bind(userLoginViewModel.errorProperty());
    loginPasswordField.textProperty().bindBidirectional(userLoginViewModel.passwordProperty());
    loginUsernameField.textProperty().bindBidirectional(userLoginViewModel.usernameProperty());
  }
  public void onLoginButton( )
  {
    boolean value = userLoginViewModel.login();
    if(value)
    {
      viewHandler.openChatWindow();
      //set the username label of chatViewModel
      String user = userLoginViewModel.usernameProperty().get();
      viewHandler.getVmf().getChatWindowViewModel().userNameProperty().set(user);
      viewHandler.getVmf().getChatWindowViewModel().setUserName(user);

    }
    else
      userLoginViewModel.setErrorLabel();
  }

  public void onSignUpButton( )
  {
    viewHandler.openSignUpWindow();
  }


}
