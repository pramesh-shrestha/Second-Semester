package login.viewmodels;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import login.model.LoginModelBase;
import login.modelimpls.LoginModelInMemory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreateUserVMTest
{
  private CreateUserVM createUserVM;

  @Before public void setUp() throws Exception
  {
    LoginModelBase modelBase = new LoginModelInMemory();
    modelBase.populateModelWithDummyusers();
    createUserVM = new CreateUserVM(modelBase);
  }

  @Test
  public void createValidUser_OtherTroels_12345678Az()
  {
    //arrange
    StringProperty username = new SimpleStringProperty();
    StringProperty password = new SimpleStringProperty();
    StringProperty passwordAgain = new SimpleStringProperty();
    StringProperty result = new SimpleStringProperty();
    createUserVM.usernameProperty().bindBidirectional(username);
    createUserVM.passwordProperty().bindBidirectional(password);
    createUserVM.passwordAgainProperty().bindBidirectional(passwordAgain);
    createUserVM.createUserResultProperty().bindBidirectional(result);

    //Act
    username.setValue("OtherTroels");
    password.setValue("12345678Az");
    passwordAgain.setValue("12345678Az");
    createUserVM.attemptCreateUser();

    //assert
    assertEquals("OK", result.getValue());
  }
}