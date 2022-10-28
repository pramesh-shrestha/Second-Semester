package client.core;

import client.clientViewModel.ChatWindowViewModel;
import client.clientViewModel.SignUpViewModel;
import client.clientViewModel.UserLoginViewModel;

public class ViewModelFactory
{
  private ModelFactory modelFactory;
  private SignUpViewModel signUpViewModel;
  private UserLoginViewModel userLoginViewModel;
  private ChatWindowViewModel chatWindowViewModel;

  public ViewModelFactory(ModelFactory modelFactory)
  {
    this.modelFactory = modelFactory;
    signUpViewModel = new SignUpViewModel(modelFactory.getClientChatModel());
    userLoginViewModel = new UserLoginViewModel(modelFactory.getClientChatModel());
    chatWindowViewModel = new ChatWindowViewModel(modelFactory.getClientChatModel());
  }

  public SignUpViewModel getSignUpViewModel()
  {
    return signUpViewModel;
  }

  public UserLoginViewModel getUserLoginViewModel()
  {
    return userLoginViewModel;
  }

  public ChatWindowViewModel getChatWindowViewModel()
  {
    return chatWindowViewModel;
  }
}
